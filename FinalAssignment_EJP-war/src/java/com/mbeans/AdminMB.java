/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.entitiybeans.Admin;
import com.entitiybeans.Users;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sessionbeans.AdminFacadeLocal;
import sessionbeans.UsersFacadeLocal;

/**
 *
 * @author odieng
 */
@Named(value = "adminMB")
@SessionScoped
public class AdminMB implements Serializable {

    @Inject
    private AdminMB lad;
    @EJB
    private AdminFacadeLocal adminFacade;

    private Integer adminID;
    private String fullname;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String status;
    private Admin admin;
    private boolean flag = false;
    private String message = "";

    public AdminMB() {
        admin = new Admin();
    }

    public void checkLoginSuccess() {
        if (username == null) {
            ExternalContext ec = FacesContext.getCurrentInstance()
                    .getExternalContext();
            try {
                ec.redirect(ec.getRequestContextPath()
                        + "/faces/admin/loginAdmin.xhtml");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public List<Admin> showAllAdmin() {
        return adminFacade.findAll();
    }

    public String showUpdateAdmin(String username) {
        admin = adminFacade.findByUsername(username);
        System.out.println("------------------------------------------+=====" + username);
        return "adminProfile";
    }

    public String saveUpdate() {
        adminFacade.edit(admin);
        return "adminProfile";
    }

    public String checkLoginAdmin() {
        if (adminFacade.checkLoginAdmin(admin.getUsername(), admin.getPassword())) {
            admin = adminFacade.findByUsername(admin.getUsername());
            lad.setUsername(admin.getUsername());
            flag = true;
            return "index";
        }
        message = "Login failed. Please log in again!";
        return "loginAdmin";
    }

    public void checkLoginStatus() {
        if (flag == false) {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect("loginAdmin.xhtml");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "loginAdmin";
    }

//    public String showUpdateAdmin(Integer idA) {
//        admin = adminFacade.find(idA);
//        adminID = admin.getId();
//        return "updateAdmin";
//    }
    public String saveUpdateAdmins() {
        adminFacade.edit(admin);
        return "displayAdmin";
    }

    public AdminFacadeLocal getAdminFacade() {
        return adminFacade;
    }

    public void setAdminFacade(AdminFacadeLocal adminFacade) {
        this.adminFacade = adminFacade;
    }

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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

    public AdminMB getL() {
        return lad;
    }

    public void setL(AdminMB l) {
        this.lad = l;
    }

}
