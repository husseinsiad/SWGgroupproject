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
import com.sg.blog.model.Post;
import com.sg.blog.model.User;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String index(Model model) {
        List<Post> posts = postdao.findAll();
        List<Category> categories = categorydao.findAll();
        model.addAttribute("post", posts);
        model.addAttribute("category", categories);
        return "index";
    }

    @GetMapping("post")
    public String post(Model model) {
        List<Category> category = categorydao.findAll();
        model.addAttribute("category", category);
        return "post";
    }

    @PostMapping("post")
    public String addPost(Post post) {
        User user = new User();
        user.setUserid(1);
        LocalDateTime date;
        date = LocalDateTime.now();
        post.setPostdate(date);
        post.setUser(user);
        postdao.save(post);
        return "redirect:/index";
    }

    @GetMapping("updatePost")
    public String updatePost(Model model, Integer id) {
        Post posts = postdao.findById(id).orElse(null);
        Category category = categorydao.findById(id).orElse(null);
        model.addAttribute("category", category);
        model.addAttribute("post", posts);
        return "UpdatePost";
    }

    @PostMapping("updatePost")
    public String performUpdatePost(Post post) {
        User user = new User();
        user.setUserid(1);// should be dynamic
        LocalDateTime date;
        date = LocalDateTime.now();
        post.setPostdate(date);
        post.setUser(user);
        postdao.save(post);
        return "redirect:/index";
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
    
    @GetMapping("deletePost")
    public String deletePost(int id){
        postdao.deleteById(id);
        return "redirect:/index";
    }
    
    @GetMapping("postsByCategory")
    public String getPostsByCategory(Integer id, Model model){
        Category category = categorydao.findById(id).orElse(null);
        List<Post> posts = category.getPost();
        
        model.addAttribute("post", posts);
        model.addAttribute("category", category);
        
        return "postsByCategory";
    }
  
}
