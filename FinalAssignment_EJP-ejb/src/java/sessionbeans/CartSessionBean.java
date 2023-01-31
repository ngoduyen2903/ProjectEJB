/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateful;

/**
 *
 * @author odieng
 */
@Stateful
public class CartSessionBean implements CartSessionBeanLocal {

    Map<Long, Integer> mycart = new HashMap();

    @Override
    public void addCart(Long id, int quanlity) {
        if (mycart.containsKey(id)) {
            mycart.replace(id, mycart.get(id).intValue() + 1);
        } else {
            mycart.put(id, 1);
        }
    }

    @Override
    public void removeCart(Long id) {
        mycart.remove(id);
    }

    @Override
    public void updateCart(Long id, boolean flag) {
        if (flag) {
            mycart.replace(id, mycart.get(id).intValue() + 1);
        } else {
            mycart.replace(id, mycart.get(id).intValue() - 1);
        }
    }

    @Override
    public Map<Long, Integer> showCartMap() {
        return mycart;
    }

    @Override
    public void emptyCart() {
        mycart.clear();
    }

    @Override
    public int countCart() {
        return mycart.size();
    }
}
