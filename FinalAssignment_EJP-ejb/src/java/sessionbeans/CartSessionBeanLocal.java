/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author odieng
 */
@Local
public interface CartSessionBeanLocal {

    public void addCart(Long id, int quanlity);
    
    public Map<Long, Integer> showCartMap();

    public int countCart();

    public void removeCart(Long id);

    public void emptyCart();

    public void updateCart(Long id, boolean flag);

}
