package com.example.Blogging.platform.API.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private Integer postId;
    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;
    @Column(name="post_details")
    private String postDetails;
    @Column(name="created_date")
    private Timestamp createdDate;


}
