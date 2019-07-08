/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.data;

import com.sg.blog.model.Post;
import java.util.List;

/**
 *
 * @author hause
 */
public interface PostDao {
    
    List<Post> getAllPosts();
    Post getPostById(int id);
    Post addPost(Post post);
    void updatePost(Post post);
    void deletePost(int id);
    
}
