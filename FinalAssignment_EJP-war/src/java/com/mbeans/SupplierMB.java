/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.entitiybeans.Categories;
import com.entitiybeans.Suppliers;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sessionbeans.SuppliersFacadeLocal;

/**
 *
 * @author odieng
 */
@Named(value = "supplierMB")
@RequestScoped
public class SupplierMB {

    @EJB
    private SuppliersFacadeLocal suppliersFacade;
    private String supplierName;
    private String address;
    private String phone;
    private String homePage;
    private Suppliers supplier;
    private Long supplierID;
    private String findNameSup;

    public SupplierMB() {
        supplier = new Suppliers();
    }

    public String insertSuppliers() {
        suppliersFacade.create(supplier);
        return "displaySupplier";
    }

    public String showUpdateSuppliers(Long id) {
        supplier = suppliersFacade.find(id);
       // supplierID = supplier.getSupID();
       Suppliers suppliers = supplier;
        return "updateSupplier";
    }

    public String saveUpdate() {
        suppliersFacade.edit(supplier);
        return "displaySupplier";
    }

    public String deleteSuppliers(Long id) {
        suppliersFacade.remove(suppliersFacade.find(id));
        return "displaySupplier";
    }

    public String findSupplierByName() {
        return "displaySupplier";
    }

    public List<Suppliers> showAllSuppliers() {
        return suppliersFacade.findAll();
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    public SuppliersFacadeLocal getSuppliersFacade() {
        return suppliersFacade;
    }

    public void setSuppliersFacade(SuppliersFacadeLocal suppliersFacade) {
        this.suppliersFacade = suppliersFacade;
    }

    public Long getIdSup() {
        return supplierID;
    }

    public void setIdSup(Long idSup) {
        this.supplierID = idSup;
    }

    public String getFindNameSup() {
        return findNameSup;
    }

    public void setFindNameSup(String findNameSup) {
        this.findNameSup = findNameSup;
    }

    public Long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

}
