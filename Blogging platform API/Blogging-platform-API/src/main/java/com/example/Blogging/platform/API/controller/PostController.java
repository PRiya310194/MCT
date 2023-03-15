package com.example.Blogging.platform.API.controller;

import com.example.Blogging.platform.API.dao.UserRepository;
import com.example.Blogging.platform.API.model.Post;
import com.example.Blogging.platform.API.model.User;
import com.example.Blogging.platform.API.service.PostService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;

@RestController
//@RequestMapping(value="/api/v1/post")

public class PostController {
    @Autowired
    PostService postService;
@Autowired
    UserRepository userRepository;
    @PostMapping(value="save-post")
    public ResponseEntity<String> savePost(@RequestBody String postRequest){
        Post post=setPost(postRequest);
        int postId=postService.savePost(post);
        return new ResponseEntity<>(String.valueOf(postId), HttpStatus.CREATED);
    }

    private Post setPost(String postData) {
        JSONObject jsonObject=new JSONObject(postData);

        User user=null;
        int userId= jsonObject.getInt("userId");
        if(userRepository.findById(userId).isPresent()){
            user=userRepository.findById(userId).get();
        }
        else{
            return null;
        }
        Post post=new Post();
        post.setUser(user);
        post.setPostDetails(jsonObject.getString("postDetails"));
        Timestamp createdTime=new Timestamp((System.currentTimeMillis()));
        post.setCreatedDate(createdTime);
        return post;
    }
@GetMapping(value="/post")

public ResponseEntity<String>getPost(@Nullable @RequestParam String postId){
    JSONArray postDetails=postService.getPost(postId);
    return new ResponseEntity<>(postDetails.toString(),HttpStatus.OK);
}

    @PutMapping(value="/post/{postId}")
    public void updatePost(@PathVariable int postId, @RequestBody Post post){
        //User user=setUser(userDetails);
        postService.updatePost(postId,post);

    }
    @DeleteMapping(value="/delete/{postId}")
    public void deletePost(@PathVariable int postId){
        postService.deletePost(postId);
    }

}
