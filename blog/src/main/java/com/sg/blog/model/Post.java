/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author hause
 */
@Entity(name = "post" )
public class Post {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private int postId;
    
    @Column(nullable=false)
    private String title;
    
    @Column(nullable=false)
    private String content;
    
    @Column(nullable=false)
    private LocalDateTime postDate;
    
    @Column(nullable=false)
    private boolean status;
    
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)

    private User user;

    
    @ManyToMany
    @JoinTable(name = "post_category",
            joinColumns = {@JoinColumn(name = "postid")},
            inverseJoinColumns = {@JoinColumn(name = "categoryid")})
    private List<Category> categories;


    
}
