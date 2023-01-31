package com.entitiybeans;

import com.entitiybeans.Categories;
import com.entitiybeans.OrderDetails;
import com.entitiybeans.Suppliers;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-01-31T12:28:25")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, Double> unitPrice;
    public static volatile SingularAttribute<Products, String> image;
    public static volatile SingularAttribute<Products, Suppliers> supID;
    public static volatile SingularAttribute<Products, Integer> quantity;
    public static volatile CollectionAttribute<Products, OrderDetails> orderDetailsCollection;
    public static volatile SingularAttribute<Products, Long> proID;
    public static volatile SingularAttribute<Products, String> productName;
    public static volatile SingularAttribute<Products, Integer> statusSale;
    public static volatile SingularAttribute<Products, Categories> categoryID;

}