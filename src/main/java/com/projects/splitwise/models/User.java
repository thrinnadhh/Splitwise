package com.projects.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Entity(name = "MyUsers")
public class User extends BaseModel {
    private String name;
    private String phoneNumber;
    private String password;

    //    User N:M UserGroups
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Group> groups;
//    User 1:m Expense
    @OneToMany(mappedBy = "user")
    private List<Expense> expenses;


}
