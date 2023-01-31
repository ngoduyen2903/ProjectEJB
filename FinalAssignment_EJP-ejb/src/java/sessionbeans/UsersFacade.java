/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import com.entitiybeans.Users;
import com.entitiybeans.Users_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author odieng
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {

    @PersistenceContext(unitName = "FinalAssignment_EJP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    @Override
    public boolean checkLoginUser(String username, String password) {
        boolean flag = false;
        try {
            Query query = em.createQuery("select u from Users u where u.username =:uname and u.password = :pword");
            query.setParameter("uname", username);
            query.setParameter("pword", password);
            query.getSingleResult();
            flag = true;
        } catch (NoResultException ex) {
            flag = false;
        }
        return flag;
    }

    @Override
    public Users findByUsername(String username) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root r = cq.from(Users.class);
        cq.select(r);
        cq.where(cb.equal(r.get(Users_.username), username));
        Query query = em.createQuery(cq);
        return (Users) query.getSingleResult();
    }

    @Override
    public Long loginUser(String username, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root r = cq.from(Users.class);
        cq.select(cb.count(r.get(Users_.username)));
        cq.where(cb.and(cb.equal(r.get(Users_.username), username),cb.equal(r.get(Users_.password), password)));
        Query query = em.createQuery(cq);
        return (Long) query.getSingleResult();
    }

}
