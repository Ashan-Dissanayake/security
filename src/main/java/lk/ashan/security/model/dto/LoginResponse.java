package lk.ashan.security.model.dto;

public class LoginResponse {
    private String token;
    private String username;

    public LoginResponse(String token,String username) {
        this.token = token;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }


}
