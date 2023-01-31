/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.entitiybeans.OrderDetails;
import com.entitiybeans.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import sessionbeans.OrderDetailsFacadeLocal;
import sessionbeans.UsersFacadeLocal;

/**
 *
 * @author odieng
 */
@Named(value = "orderDetailsMB")
@RequestScoped
public class OrderDetailsMB {

    @Inject
    private LoginMB l;
    @EJB
    private UsersFacadeLocal usersFacade;
    @EJB
    private OrderDetailsFacadeLocal orderDetailsFacade;

    private Long id;
    private Double priceEach;
    private int quantityOrdered;
    private Double totalPrice;
    private Long orderID;
    private Integer idUser;

    public OrderDetailsMB() {
    }

    public List<OrderDetails> showAllOrderDetails() {
        Users users = usersFacade.findByUsername(l.getUsername());
        System.out.println("---------------------------------" + orderDetailsFacade.findByAllUserid(users.getId()).size()+"==========="+users.getId());
        return orderDetailsFacade.findByAllUserid(users.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(Double priceEach) {
        this.priceEach = priceEach;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public LoginMB getL() {
        return l;
    }

    public void setL(LoginMB l) {
        this.l = l;
    }

}
