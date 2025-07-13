package lk.ashan.security.controller;

import lk.ashan.security.dao.UserDao;
import lk.ashan.security.entity.User;
import lk.ashan.security.entity.Userrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired private UserDao userDao;

    @GetMapping(produces = "application/json")
    public List<User> getAll(){
        return this.userDao.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public HashMap<String,String> add(@RequestBody User user){

        HashMap<String,String> responce = new HashMap<>();

        String errors="";

        if( this.userDao.findByUsername(user.getUsername()).isPresent())
            errors = errors+"<br> Existing Username";

        if(errors.isEmpty()){
            for(Userrole u : user.getUserroles()) u.setUser(user);

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            this.userDao.save(user);

            responce.put("id",String.valueOf(user.getId()));
            responce.put("url","/users/"+user.getId());
            responce.put("errors",errors);

            return responce;
        }

        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(user.getId()));
        responce.put("url","/users/"+user.getId());
        responce.put("errors",errors);

        return responce;
    }

}
