/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import com.entitiybeans.OrderDetails;
import com.entitiybeans.OrderDetails_;
import com.entitiybeans.Orders;
import com.entitiybeans.Orders_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author kyqua
 */
@Stateless
public class OrderDetailsFacade extends AbstractFacade<OrderDetails> implements OrderDetailsFacadeLocal {

    @PersistenceContext(unitName = "FinalAssignment_EJP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderDetailsFacade() {
        super(OrderDetails.class);
    }

    @Override
    public List<OrderDetails> findByAllUserid(Integer userid) {
        String sql = "select odd from OrderDetails odd where odd.orderID.id.id = ?1";
        Query query = em.createQuery(sql,OrderDetails.class);
        query.setParameter(1, userid);
        return query.getResultList();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery cq = cb.createQuery(OrderDetails.class);
//        Root<OrderDetails> root = cq.from(OrderDetails.class);
//        cq.select(root);
//        Join<OrderDetails, Orders> join = root.join(OrderDetails_.orderID);
//        cq.where(cb.equal(join.get(Orders_.id).get("id"), userid));
//        Query query = em.createQuery(cq);
//        return query.getResultList();
    }

}
