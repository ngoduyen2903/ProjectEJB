/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import com.entitiybeans.Admin;
import com.entitiybeans.Admin_;
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
public class AdminFacade extends AbstractFacade<Admin> implements AdminFacadeLocal {

    @PersistenceContext(unitName = "FinalAssignment_EJP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }

    @Override
    public boolean checkLoginAdmin(String username, String password) {
        boolean flag = false;
        try {
            Query query = em.createQuery("select a from Admin a where a.username =:uname and a.password = :pword");
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
    public Admin findByUsername(String username) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root r = cq.from(Admin.class);
        cq.select(r);
        cq.where(cb.equal(r.get(Admin_.username), username));
        Query query = em.createQuery(cq);
        return (Admin) query.getSingleResult();
    }
}
