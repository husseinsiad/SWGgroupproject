/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.data;

import com.sg.blog.model.About;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author siyaa
 */
public interface AboutDao extends JpaRepository<About, Integer>{
    
}
