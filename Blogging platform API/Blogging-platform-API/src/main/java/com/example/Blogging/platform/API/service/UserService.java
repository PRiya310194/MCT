package com.example.Blogging.platform.API.service;

import com.example.Blogging.platform.API.dao.UserRepository;
import com.example.Blogging.platform.API.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int saveUser(User user) {
        User userObj=userRepository.save(user);
        return userObj.getUserId();
    }

    public JSONArray getUser(String userId) {
        JSONArray userArray=new JSONArray();
        if(null!=userId && userRepository.findById(Integer.valueOf(userId)).isPresent()){
            User user=userRepository.findById(Integer.valueOf(userId)).get();
            JSONObject userObject=setUser(user);
            userArray.put(userObject);
        }
        else {
            List<User> userList = userRepository.findAll();
            for (User user : userList) {
                JSONObject userObject = setUser(user);
                userArray.put(userObject);

            }
        }
            return userArray;
        }
        private JSONObject setUser(User user){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("userName",user.getUserName());
            jsonObject.put("password",user.getPassword());
            jsonObject.put("email",user.getEmail());
            jsonObject.put("phoneNumber",user.getPhoneNumber());
            jsonObject.put("firstName",user.getFirstName());
            jsonObject.put("lastName",user.getLastName());
            jsonObject.put("age",user.getAge());
            return jsonObject;
        }


    public void updateUser(int userId, User user) {
if(userRepository.findById(userId).isPresent()){
User userData=userRepository.findById(userId).get();
user.setUserId(user.getUserId());
userRepository.save(user);

    }
}

    public void deleteUser(int userId) {
        User user=userRepository.findById(userId).get();
        userRepository.delete(user);
    }
}

