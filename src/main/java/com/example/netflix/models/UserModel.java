package com.example.netflix.models;


import com.example.netflix.utils.AuthDTO;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Column
    String username;

    @NotNull
    @Column
    String password;

    @NotNull
    @Column
    Role role;
    @OneToMany(cascade=CascadeType.REMOVE)
    List<Movie> createdMovies;
    @OneToMany(cascade=CascadeType.REMOVE)
    List<Series> createdSeries;

    public List<Series> getCreatedSeries() {
        return createdSeries;
    }

    public void setCreatedSeries(List<Series> createdSeries) {
        this.createdSeries = createdSeries;
    }

    public UserModel() {}

    public UserModel(String username, String password, Role role, List<Movie> createdMovies, List<Series> createdSeries) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdMovies = createdMovies;
        this.createdSeries=createdSeries;
    }

    public static UserModel from(AuthDTO authDTO) {
        UserModel userModel = new UserModel();
        userModel.username = authDTO.username;
        userModel.password = authDTO.password;
        userModel.role = Role.USER;
        userModel.createdMovies = new ArrayList<>();
        userModel.createdSeries=new ArrayList<>();
        return userModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Movie> getCreatedMovies() {
        return createdMovies;
    }

    public void setCreatedMovies(List<Movie> createdMovies) {
        this.createdMovies = createdMovies;
    }
}
