/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.entitiybeans.Products;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import sessionbeans.ProductsFacadeLocal;

/**
 *
 * @author odieng
 */
@Named(value = "testMB")
@SessionScoped
public class TestMB implements Serializable {

    private Products products;
    private int quantityCart;

    @EJB
    private ProductsFacadeLocal productsFacade;

    /**
     * Creates a new instance of TestMB
     */
    public TestMB() {
        products = new Products();
    }

    public List<Products> showAllPro() {
        return productsFacade.findAll();
    }

    public String showProductDetails(Long idPro) {
        products = productsFacade.find(idPro);
        return "shop-details";
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(int quantityCart) {
        this.quantityCart = quantityCart;
    }

}
