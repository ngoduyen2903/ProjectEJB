/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import com.entitiybeans.Users;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author odieng
 */
@Local
public interface UsersFacadeLocal {

    void create(Users users);

    void edit(Users users);

    void remove(Users users);

    Users find(Object id);

    List<Users> findAll();

    List<Users> findRange(int[] range);

    int count();

    public boolean checkLoginUser(String username, String password);

    Users findByUsername(String username);

    Long loginUser(String username, String password);

}
