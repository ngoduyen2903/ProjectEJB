/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.entitiybeans.Products;
import com.models.CartShopping;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Inject;
import sessionbeans.CartSessionBeanLocal;
import sessionbeans.ProductsFacadeLocal;

/**
 *
 * @author odieng
 */
@Named(value = "cartProductMB")
@SessionScoped
public class CartProductMB implements Serializable {

    @Inject
    private CartProductMB cartProductMB;
    //session
    @Inject
    private LoginMB l;
    @EJB
    private ProductsFacadeLocal productsFacade;
    @EJB
    private CartSessionBeanLocal cartSessionBean;
    private int num;
    List<Integer> numCart = new ArrayList<>();
    private double totalMoneyCart;
    private int totalProCart;
    private String message = "";
    private Double ship = 1.0;

    public CartProductMB() {
    }

    public String test(Long id) {
        System.out.println("-----------------------------------------------------------" + id);
        return "cart";
    }

    public String addCartProduct(Long idPro) {
        //session
        if (l.getUsername() == null) {
            return "login";
        }
        Long a = idPro;
        System.out.println("--------------------------------------------------------" + a);
        cartSessionBean.addCart(idPro, 1);
        message = "Product added to cart successfully!";
        return "cart";
    }

    public List<CartShopping> showCartMB() {
        List<CartShopping> listCart = new ArrayList<>();
        Set<Map.Entry<Long, Integer>> setCart = cartSessionBean.showCartMap().entrySet();
        totalMoneyCart = 0;
        totalProCart = 0;
        for (Map.Entry<Long, Integer> e : setCart) {
            Long id = e.getKey();
            Integer quality = e.getValue();
            Products pro = productsFacade.find(id);
            double uprice = pro.getUnitPrice().doubleValue();
            CartShopping cShop = new CartShopping(id, pro.getProductName(), quality, uprice, quality * uprice, pro.getImage());
            listCart.add(cShop);
            numCart.add(quality);
            totalMoneyCart += quality * uprice;
            totalProCart += quality;
        }
        return listCart;
    }

    public void updateCart(Long id, boolean flag) {
        cartSessionBean.updateCart(id, flag);
    }

    public String removeCart(Long id) {
        cartSessionBean.removeCart(id);
        message = "Removed a product from the cart!";
        return "cart";
    }

    public String emptyCart() {
        cartSessionBean.emptyCart();
        return "cart";
    }

    public int countCart() {
        return cartSessionBean.countCart();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getTotalMoneyCart() {
        return totalMoneyCart;
    }

    public void setTotalMoneyCart(double totalCart) {
        this.totalMoneyCart = totalCart;
    }

    public int getTotalProCart() {
        return totalProCart;
    }

    public void setTotalProCart(int totalProCart) {
        this.totalProCart = totalProCart;
    }

    public LoginMB getL() {
        return l;
    }

    public void setL(LoginMB l) {
        this.l = l;
    }

    public CartProductMB getCartProductMB() {
        return cartProductMB;
    }

    public void setCartProductMB(CartProductMB cartProductMB) {
        this.cartProductMB = cartProductMB;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getShip() {
        return ship;
    }

    public void setShip(Double ship) {
        this.ship = ship;
    }
}
