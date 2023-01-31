/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.entitiybeans.Categories;
import com.entitiybeans.OrderDetails;
import com.entitiybeans.Orders;
import com.entitiybeans.Products;
import com.entitiybeans.Users;
import com.models.CartShopping;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.OrderDetailsFacadeLocal;
import sessionbeans.OrdersFacadeLocal;
import sessionbeans.ProductsFacadeLocal;
import sessionbeans.UsersFacade;
import sessionbeans.UsersFacadeLocal;

/**
 *
 * @author odieng
 */
@Named(value = "checkoutMB")
@RequestScoped
public class CheckoutMB {

    @Inject
    private AdminMB lad;
    @EJB
    private ProductsFacadeLocal productsFacade;

    @EJB
    private OrderDetailsFacadeLocal orderDetailsFacade;

    @Inject
    private CartProductMB cartProductMB;
    @EJB
    private OrdersFacadeLocal ordersFacade;

    @Inject
    private LoginMB l;
    @EJB
    private UsersFacadeLocal usersFacade;

    private Long OrderID;
    private String orderDate;
    private String phoneShip;
    private String addressShip;
    private String note;
    private int totalAmount;
    private String orderStatus;
    private Integer userID;
    private Orders order = new Orders();

    private String message = "";

    public CheckoutMB() {

    }

    public String showStatus(Long orderID) {
        Orders or = ordersFacade.find(orderID);
        System.out.println("diendiendiendiendiendiendiendiendien" + or.getOrderID() + "----------" + or.getOrderStatus());
        if (or.getOrderStatus().compareTo("1") == 0) {
            or.setOrderStatus("2");
        } else {
            or.setOrderStatus("1");
        }
        ordersFacade.edit(or);
        return "displayOrder";
    }

    public List<Orders> showAllOrders() throws IOException {
        return ordersFacade.findAll();
    }

    public String insertBillInfor() {
        List<CartShopping> cartList = cartProductMB.showCartMB();
        Users user = usersFacade.findByUsername(l.getUsername());
        LocalDate today = LocalDate.now();
        Date date = java.sql.Date.valueOf(today);
        order.setId(user);
        order.setOrderDate(date);
        order.setTotalAmount(cartList.size());
        Orders o = order;
        order.setOrderStatus("2");
        ordersFacade.create(order);
        for (CartShopping item : cartList) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderID(order);
            orderDetails.setPriceEach(item.getUnitPrice());
            orderDetails.setProID(productsFacade.find(item.getProID()));
            orderDetails.setQuantityOrdered(item.getQuantity());
            orderDetails.setTotalPrice(item.getTotalPrice());
            orderDetailsFacade.create(orderDetails);
        }
        message = "Ordered successfully!";
        return "checkout";

    }

    public Long getOrderID() {
        return OrderID;
    }

    public void setOrderID(Long OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPhoneShip() {
        return phoneShip;
    }

    public void setPhoneShip(String phoneShip) {
        this.phoneShip = phoneShip;
    }

    public String getAddressShip() {
        return addressShip;
    }

    public void setAddressShip(String addressShip) {
        this.addressShip = addressShip;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public CartProductMB getCartProductMB() {
        return cartProductMB;
    }

    public void setCartProductMB(CartProductMB cartProductMB) {
        this.cartProductMB = cartProductMB;
    }

    public AdminMB getLad() {
        return lad;
    }

    public void setLad(AdminMB lad) {
        this.lad = lad;
    }
}
