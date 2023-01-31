/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.entitiybeans.Categories;
import com.entitiybeans.Products;
import com.entitiybeans.Suppliers;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import sessionbeans.CategoriesFacadeLocal;
import sessionbeans.ProductsFacadeLocal;
import sessionbeans.SuppliersFacadeLocal;

/**
 *
 * @author odieng
 */
@Named(value = "productMB")
@RequestScoped
public class ProductMB {

    @Inject
    private AdminMB l;
    @EJB
    private CategoriesFacadeLocal categoriesFacade;

    @EJB
    private SuppliersFacadeLocal suppliersFacade;

    @EJB

    private ProductsFacadeLocal productsFacade;
    private Part file;
    private final String UPLOAD_DIRECTORY = "resources\\uploads";
    private String src = "file";
    private int productID;
    private String productName;
    private Long supplierID;
    private Long categoryID;
    private double unitPrice;
    private int quantity;
    private String image;
    private int status;
    private Long idPro;
    private String findNamePro = "";

    private Products product;
    private List<Products> listProducts = new ArrayList<>();

    public List<Products> showAllProducts() {
        if (!findNamePro.equals("")) {
            return productsFacade.findAllByName(findNamePro);
        }
        return productsFacade.findAll();
    }

    public List<Suppliers> showAllSuppliers() {
        return suppliersFacade.findAll();
    }

    public List<Categories> showAllCategories() {
        return categoriesFacade.findAll();
    }

    public String insertProducts() {
        String imagePath = null;
        if (file != null) {
            InputStream content = null;
            try {
                content = file.getInputStream();
                FacesContext context = FacesContext.getCurrentInstance();
                ExternalContext ec = context.getExternalContext();
                HttpServletRequest request = (HttpServletRequest) ec.getRequest();
                String applicationPath = request.getServletContext().getRealPath("");
                src = applicationPath.substring(0, applicationPath.indexOf("dist") - 1) + File.separator + "FinalAssignment_EJP-war" + File.separator + "web";
                String uploadFilePath = src + File.separator + UPLOAD_DIRECTORY;

                File fileSaveDir = new File(uploadFilePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdirs();
                }
                OutputStream outputStream = null;
                try {
                    File outputFilePath = new File(uploadFilePath + File.separator + file.getSubmittedFileName());
                    imagePath = file.getSubmittedFileName();
                    content = file.getInputStream();
                    outputStream = new FileOutputStream(outputFilePath);
                    int read = 0;
                    final byte[] bytes = new byte[1024];
                    while ((read = content.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                    System.out.println("File uploaded successfully!");
                } catch (Exception ex) {
                    ex.toString();
                } finally {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (content != null) {
                        content.close();
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(image).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    content.close();
                } catch (IOException ex) {
                    Logger.getLogger(image).log(Level.SEVERE, null, ex);
                }
            }
        }
        Categories cate = categoriesFacade.find(categoryID);
        Suppliers sup = suppliersFacade.find(supplierID);
        product.setCategoryID(cate);
        product.setSupID(sup);
        Products p = product;
        //
        productsFacade.create(product);
        List<Products> listPro = productsFacade.findAll();
        product = listPro.get(listPro.size() - 1);

        product.setImage("uploads\\".concat(imagePath));
        productsFacade.edit(product);

        return "displayProduct";
    }

    public String showUpdateProduct(Long id) {
        product = productsFacade.find(id);
        idPro = product.getProID();
        return "updateProduct";
    }

    public String saveUpdate() {
        String imagePath = null;
        if (file != null) {
            InputStream content = null;
            try {
                content = file.getInputStream();
                FacesContext context = FacesContext.getCurrentInstance();
                ExternalContext ec = context.getExternalContext();
                HttpServletRequest request = (HttpServletRequest) ec.getRequest();
                String applicationPath = request.getServletContext().getRealPath("");
                src = applicationPath.substring(0, applicationPath.indexOf("dist") - 1) + File.separator + "FinalAssignment_EJP-war" + File.separator + "web";
                String uploadFilePath = src + File.separator + UPLOAD_DIRECTORY;

                File fileSaveDir = new File(uploadFilePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdirs();
                }
                OutputStream outputStream = null;
                try {
                    File outputFilePath = new File(uploadFilePath + File.separator + file.getSubmittedFileName());
                    imagePath = file.getSubmittedFileName();
                    content = file.getInputStream();
                    outputStream = new FileOutputStream(outputFilePath);
                    int read = 0;
                    final byte[] bytes = new byte[1024];
                    while ((read = content.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                    System.out.println("File uploaded successfully!");
                } catch (Exception ex) {
                    ex.toString();
                } finally {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (content != null) {
                        content.close();
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(image).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    content.close();
                } catch (IOException ex) {
                    Logger.getLogger(image).log(Level.SEVERE, null, ex);
                }
            }
        }
        Suppliers sup = suppliersFacade.find(supplierID);
        Categories cate = categoriesFacade.find(categoryID);
        product.setCategoryID(cate);
        product.setSupID(sup);
        product.setImage("uploads\\".concat(imagePath));
        productsFacade.edit(product);
        return "displayProduct";
    }

    public String deleteProduct(Long id) {
        productsFacade.remove(productsFacade.find(id));
        return "displayProduct";
    }

    public String findProductByName() {
        return "displayProduct";
    }

    public List<Products> showFindProduct() {
        return listProducts;
    }

    public ProductMB() {
        product = new Products();

    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public ProductsFacadeLocal getProductsFacade() {
        return productsFacade;
    }

    public void setProductsFacade(ProductsFacadeLocal productsFacade) {
        this.productsFacade = productsFacade;
    }

    public Long getIdPro() {
        return idPro;
    }

    public void setIdPro(Long idPro) {
        this.idPro = idPro;
    }

    public CategoriesFacadeLocal getCategoriesFacade() {
        return categoriesFacade;
    }

    public void setCategoriesFacade(CategoriesFacadeLocal categoriesFacade) {
        this.categoriesFacade = categoriesFacade;
    }

    public SuppliersFacadeLocal getSuppliersFacade() {
        return suppliersFacade;
    }

    public void setSuppliersFacade(SuppliersFacadeLocal suppliersFacade) {
        this.suppliersFacade = suppliersFacade;
    }

    public String getFindNamePro() {
        return findNamePro;
    }

    public void setFindNamePro(String findNamePro) {
        this.findNamePro = findNamePro;
    }

    public List<Products> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Products> listProducts) {
        this.listProducts = listProducts;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

}
