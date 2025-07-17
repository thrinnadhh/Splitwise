package com.projects.splitwise.models;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "UserGroup")
public class Group extends BaseModel{
    private String name;
    private String description;

//    group 1:m Expense
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;

//    group m:1 Admin
    @ManyToOne
    private User admin;

    @ManyToMany(mappedBy = "groups")
    private List<User> members;
}
