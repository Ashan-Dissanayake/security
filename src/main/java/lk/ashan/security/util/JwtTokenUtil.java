package lk.ashan.security.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Base64;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.accessExpiration}")
    private int accessExpiration;

    private SecretKey signingKey;

    @PostConstruct
    public void init() {
        byte[] decodedKey = Base64.getDecoder().decode(secret);
        this.signingKey = Keys.hmacShaKeyFor(decodedKey);
    }

    public String generateAccessToken(UserDetails userDetails) {
        return generateToken(userDetails, accessExpiration);
    }

    private String generateToken(UserDetails userDetails, int expirationInSeconds) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationInSeconds * 1000L))
                .signWith(signingKey, SignatureAlgorithm.HS512)
                .compact();
    }

    public String extractUsername(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username != null
                && username.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        try {
            Date expirationDate = Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();
            return expirationDate.before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return true;
        }
    }
}
