/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entitiybeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author odieng
 */
@Entity
@Table(name = "Image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i")
    , @NamedQuery(name = "Image.findByImageID", query = "SELECT i FROM Image i WHERE i.imageID = :imageID")
    , @NamedQuery(name = "Image.findByProID", query = "SELECT i FROM Image i WHERE i.proID = :proID")
    , @NamedQuery(name = "Image.findByImage1", query = "SELECT i FROM Image i WHERE i.image1 = :image1")
    , @NamedQuery(name = "Image.findByImage2", query = "SELECT i FROM Image i WHERE i.image2 = :image2")
    , @NamedQuery(name = "Image.findByImage3", query = "SELECT i FROM Image i WHERE i.image3 = :image3")
    , @NamedQuery(name = "Image.findByImage4", query = "SELECT i FROM Image i WHERE i.image4 = :image4")})
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ImageID")
    private Long imageID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProID")
    private long proID;
    @Size(max = 255)
    @Column(name = "Image1")
    private String image1;
    @Size(max = 255)
    @Column(name = "Image2")
    private String image2;
    @Size(max = 255)
    @Column(name = "Image3")
    private String image3;
    @Size(max = 255)
    @Column(name = "Image4")
    private String image4;

    public Image() {
    }

    public Image(Long imageID) {
        this.imageID = imageID;
    }

    public Image(Long imageID, long proID) {
        this.imageID = imageID;
        this.proID = proID;
    }

    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public long getProID() {
        return proID;
    }

    public void setProID(long proID) {
        this.proID = proID;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageID != null ? imageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Image)) {
            return false;
        }
        Image other = (Image) object;
        if ((this.imageID == null && other.imageID != null) || (this.imageID != null && !this.imageID.equals(other.imageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entitiybeans.Image[ imageID=" + imageID + " ]";
    }
    
}
