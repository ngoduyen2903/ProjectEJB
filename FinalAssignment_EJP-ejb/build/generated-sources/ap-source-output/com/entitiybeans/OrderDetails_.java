package com.entitiybeans;

import com.entitiybeans.Orders;
import com.entitiybeans.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-01-31T12:28:25")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Double> totalPrice;
    public static volatile SingularAttribute<OrderDetails, Orders> orderID;
    public static volatile SingularAttribute<OrderDetails, Products> proID;
    public static volatile SingularAttribute<OrderDetails, Integer> quantityOrdered;
    public static volatile SingularAttribute<OrderDetails, Long> id;
    public static volatile SingularAttribute<OrderDetails, Double> priceEach;

}