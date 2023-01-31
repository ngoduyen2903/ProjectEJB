/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.entitiybeans.Users;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import sessionbeans.UsersFacadeLocal;

/**
 *
 * @author odieng
 */
@Named(value = "userMB")
@RequestScoped
public class UserMB {

    @EJB
    private UsersFacadeLocal usersFacade;

    private Integer userID;
    private String fullname;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String status;
    private Users user = new Users();
    private boolean flag = false;
    private String message = "";

    public UserMB() {

    }

    public List<Users> showAllUsers() {
        return usersFacade.findAll();
    }

    public String showUpdateUsers(String username) {
        user = usersFacade.findByUsername(username);
        Integer id = user.getId();
        user = usersFacade.find(id);
        System.out.println("============================"+user.toString());
        userID = user.getId();
        return "userProfile";
    }

    public String saveUpdateUsers() {
        System.out.println("---------------------++++++++++++++++++++"+user.toString());
        usersFacade.edit(user);
        return "userProfile";
    }

    public int getIdUser() {
        return userID;
    }

    public void setIdUser(int idUser) {
        this.userID = idUser;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
