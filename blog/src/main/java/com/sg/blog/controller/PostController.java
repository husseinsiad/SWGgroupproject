/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.controller;

import com.sg.blog.data.PostDao;
import com.sg.blog.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author hause
 */
@Controller
public class PostController {
    
    @Autowired
    UserDao userdao;
     @Autowired
    PostDao postdao;
     
     @GetMapping("/")
     public String index(){
         // post
         return "index";
     }
}
