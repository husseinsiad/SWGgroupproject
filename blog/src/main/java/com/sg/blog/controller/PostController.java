/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.controller;

import com.sg.blog.data.CategoryDao;
import com.sg.blog.data.PostDao;
import com.sg.blog.data.UserDao;
import com.sg.blog.model.Category;
import com.sg.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    
    @Autowired
    CategoryDao categorydao;

    @GetMapping("index")
    public String index() {
        // post
        return "index";
    }

    @GetMapping("post")
    public String post() {
        // post
        return "post";
    }

    @GetMapping("login")
    public String login() {
        // post
        return "login";
    }

    @GetMapping("signup")
    public String signup() {
        // post
        return "signup";
    }

    @PostMapping("signup")
    public String registerUser(User user) {
        userdao.save(user);
        return "redirect:/login";
    }
    
     @GetMapping("category")
    public String category() {
        // post
        return "category";
    }

    @PostMapping("Category")
    public String registerCategory(Category category) {
        categorydao.save(category);
        return "redirect:/login";
    }
}
