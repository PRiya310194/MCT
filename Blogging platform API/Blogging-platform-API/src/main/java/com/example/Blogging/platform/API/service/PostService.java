package com.example.Blogging.platform.API.service;

import com.example.Blogging.platform.API.dao.PostRepository;
import com.example.Blogging.platform.API.model.Post;
import com.example.Blogging.platform.API.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;


    public int savePost(Post post) {
        Post Savepost = postRepository.save(post);
        return Savepost.getPostId();
    }

    public JSONArray getPost(String postId) {
        JSONArray postArray = new JSONArray();
        if (null != postId && postRepository.findById(Integer.valueOf(postId)).isPresent()) {
            Post post = postRepository.findById(Integer.valueOf(postId)).get();
            JSONObject postObject = setPost(post);
            postArray.put(postObject);
        } else {
            List<Post> postList = postRepository.findAll();
            for (Post post : postList) {
                JSONObject postObject = setPost(post);
                postArray.put(postObject);

            }
        }
        return postArray;
    }

    private JSONObject setPost(Post post) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", post.getUser());
        jsonObject.put("postDescription", post.getPostDetails());

        return jsonObject;
    }

    public void updatePost(int postId, Post post) {
        if(postRepository.findById(postId).isPresent()){
            Post postData=postRepository.findById(postId).get();
            post.setPostId(post.getPostId());
            postRepository.save(post);

        }
    }

    public void deletePost(int postId) {
        Post post=postRepository.findById(postId).get();
        postRepository.delete(post);
    }
}


