package com.entitiybeans;

import com.entitiybeans.OrderDetails;
import com.entitiybeans.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-01-31T12:28:25")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, String> phoneShip;
    public static volatile SingularAttribute<Orders, String> note;
    public static volatile SingularAttribute<Orders, Integer> totalAmount;
    public static volatile SingularAttribute<Orders, Long> orderID;
    public static volatile CollectionAttribute<Orders, OrderDetails> orderDetailsCollection;
    public static volatile SingularAttribute<Orders, String> addressShip;
    public static volatile SingularAttribute<Orders, String> orderStatus;
    public static volatile SingularAttribute<Orders, Users> id;
    public static volatile SingularAttribute<Orders, Date> orderDate;

}