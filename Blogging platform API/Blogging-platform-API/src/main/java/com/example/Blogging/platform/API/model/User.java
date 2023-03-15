package com.example.Blogging.platform.API.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;
    @Column(name="user_Name")
    private String userName;
    @Column(name="user_password")
    private String password;
    @Column(name="user_email")
    private String email;
    @Column(name="user_phoneNumber")
    private String phoneNumber;
    @Column(name="user_firstName")
    private String firstName;
    @Column(name="user_lastName")
    private String lastName;
    @Column(name="user_age")
    private String age;

}
