/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.data;

import com.sg.blog.model.User;
import java.util.List;

/**
 *
 * @author siyaa
 */
public interface UserDao {
    List<User> getAllUsers();
    User getUserById(int id);
    User addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    
}
