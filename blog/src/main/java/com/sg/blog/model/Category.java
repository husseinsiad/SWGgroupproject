/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.model;

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

/**
 *
 * @author harun
 */
@Entity(name = "category")
public class Category {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id   
    private int categoryid;
    
    @Column(nullable = false)
    private String name;

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
 @ManyToMany
 @JoinTable(name = "post_category",
joinColumns = {@JoinColumn(name = "categoryid")},
 inverseJoinColumns = {@JoinColumn(name = "postid")})
 private List<Post> post;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.categoryid;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        return true;
    }

}
