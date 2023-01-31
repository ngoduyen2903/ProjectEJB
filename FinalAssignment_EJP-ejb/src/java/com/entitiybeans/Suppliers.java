/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entitiybeans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author odieng
 */
@Entity
@Table(name = "Suppliers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suppliers.findAll", query = "SELECT s FROM Suppliers s")
    , @NamedQuery(name = "Suppliers.findBySupID", query = "SELECT s FROM Suppliers s WHERE s.supID = :supID")
    , @NamedQuery(name = "Suppliers.findBySupplierName", query = "SELECT s FROM Suppliers s WHERE s.supplierName = :supplierName")
    , @NamedQuery(name = "Suppliers.findByAddress", query = "SELECT s FROM Suppliers s WHERE s.address = :address")
    , @NamedQuery(name = "Suppliers.findByPhone", query = "SELECT s FROM Suppliers s WHERE s.phone = :phone")
    , @NamedQuery(name = "Suppliers.findByHomePage", query = "SELECT s FROM Suppliers s WHERE s.homePage = :homePage")})
public class Suppliers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "SupID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SupplierName")
    private String supplierName;
    @Size(max = 255)
    @Column(name = "Address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "Phone")
    private String phone;
    @Size(max = 255)
    @Column(name = "HomePage")
    private String homePage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supID")
    private Collection<Products> productsCollection;

    public Suppliers() {
    }

    public Suppliers(Long supID) {
        this.supID = supID;
    }

    public Suppliers(Long supID, String supplierName) {
        this.supID = supID;
        this.supplierName = supplierName;
    }

    public Long getSupID() {
        return supID;
    }

    public void setSupID(Long supID) {
        this.supID = supID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    @XmlTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supID != null ? supID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suppliers)) {
            return false;
        }
        Suppliers other = (Suppliers) object;
        if ((this.supID == null && other.supID != null) || (this.supID != null && !this.supID.equals(other.supID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entitiybeans.Suppliers[ supID=" + supID + " ]";
    }

}
