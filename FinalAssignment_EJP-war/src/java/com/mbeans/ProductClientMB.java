/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.entitiybeans.Products;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sessionbeans.ProductsFacadeLocal;

/**
 *
 * @author odieng
 */
@Named(value = "productClientMB")
@RequestScoped
public class ProductClientMB {

    private Products products;
    private int quantityCart;

    @EJB
    private ProductsFacadeLocal productsFacade;
    

    public ProductClientMB() {
        products = new Products();
    }

    public List<Products> showAllPro() {
        return productsFacade.findAll();
    }

    public String showProductDetails(Long idPro) {
        products = productsFacade.find(idPro);
        return "shop-details";
    }

    public int countProductinCart() {
        return 5;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public ProductsFacadeLocal getProductsFacade() {
        return productsFacade;
    }

    public void setProductsFacade(ProductsFacadeLocal productsFacade) {
        this.productsFacade = productsFacade;
    }

    public int getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(int quantityCart) {
        this.quantityCart = quantityCart;
    }

}
