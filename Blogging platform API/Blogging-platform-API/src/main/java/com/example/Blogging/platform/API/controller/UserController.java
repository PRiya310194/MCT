package com.example.Blogging.platform.API.controller;

import com.example.Blogging.platform.API.model.User;
import com.example.Blogging.platform.API.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value="/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping(value="save-user")
public ResponseEntity<String>saveUser(@RequestBody User userData){
        User user=setUser(userData);
        int userId=userService.saveUser(user);
        return new ResponseEntity<>("user saved with id ->"+userId, HttpStatus.CREATED);

    }
    private User setUser(User userData){
        JSONObject jsonObject=new JSONObject(userData);
        User user=new User();
        user.setUserName(jsonObject.getString("userName"));
        user.setPassword(jsonObject.getString("password"));
        user.setPhoneNumber(jsonObject.getString("phoneNumber"));
        user.setEmail(jsonObject.getString("email"));
        user.setFirstName(jsonObject.getString("firstName"));
        user.setLastName(jsonObject.getString("lastName"));
        user.setAge(jsonObject.getString("age"));
        return user;
    }
    @GetMapping(value="/user")
    public ResponseEntity<String>getUser(@Nullable@RequestParam String userId){
        JSONArray userDetails=userService.getUser(userId);
        return new ResponseEntity<>(userDetails.toString(),HttpStatus.OK);
    }
    @PutMapping(value="/user/{userId}")
    public void updateUser(@PathVariable int userId, @RequestBody User user){
        //User user=setUser(userDetails);
        userService.updateUser(userId,user);

    }
    @DeleteMapping(value="/delete/userId")
    public void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }

}
