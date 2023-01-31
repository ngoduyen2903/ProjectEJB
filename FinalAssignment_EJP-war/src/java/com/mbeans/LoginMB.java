/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.entitiybeans.Users;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sessionbeans.UsersFacadeLocal;

/**
 *
 * @author odieng
 */
@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    @Inject
    private LoginMB l;
    @EJB
    private UsersFacadeLocal usersFacade;

    private Integer userID;
    private String fullname;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String status;
    private Users user;
    private boolean flag = false;
    private String message = "";
    private String messagePass = "";

    private String old;
    private String newp;

    public LoginMB() {
        user = new Users();
    }

    public List<Users> showAllUsers() {
        return usersFacade.findAll();
    }

    public String updatePassword() {
        user = usersFacade.findByUsername(username);
        user.setOldPass("");
        user.setNewPass("");
        return "changePass";
    }

    public String saveUpDatePassword() {
        Users u = user;
        if (!user.getOldPass().equals(user.getPassword())) {
            messagePass = "The old password is not correct!";
        } else {
            user.setPassword(user.getNewPass());
            usersFacade.edit(user);
        }
        messagePass = "Changed password successfully!";
        return "changePass";
    }

    public String checkLogin() {
        System.out.println("------------------------------" + user.getUsername() + " --- " + user.getPassword());
        if (usersFacade.loginUser(user.getUsername(), user.getPassword()) > 0) {
            user = usersFacade.findByUsername(user.getUsername());
            l.setUsername(user.getUsername());
            flag = true;
            return "index";
        }
//        if (usersFacade.checkLoginUser(user.getUsername(), user.getPassword())) {
//            user=usersFacade.findByUsername(user.getUsername());
//            l.setUsername(user.getUsername());
//            flag = true;
//            return "index";
//        }
        message = "Login failed. Please login again!";
        return "login";
    }

    public void checkLoginStatus() {
        if (flag == false) {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect("login.xhtml");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }

    public String registerUsers() {
        usersFacade.create(user);
        return "login";
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

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public String getNewp() {
        return newp;
    }

    public void setNewp(String newp) {
        this.newp = newp;
    }

    public String getMessagePass() {
        return messagePass;
    }

    public void setMessagePass(String messagePass) {
        this.messagePass = messagePass;
    }

}
