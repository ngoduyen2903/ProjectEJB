/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import com.entitiybeans.Admin;
import com.entitiybeans.Users;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author odieng
 */
@Local
public interface AdminFacadeLocal {

    void create(Admin admin);

    void edit(Admin admin);

    void remove(Admin admin);

    Admin find(Object id);

    List<Admin> findAll();

    List<Admin> findRange(int[] range);

    int count();

    public boolean checkLoginAdmin(String username, String password);
     Admin findByUsername(String username);

}
