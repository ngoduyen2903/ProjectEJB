/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.entitiybeans.Categories;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sessionbeans.CategoriesFacadeLocal;

/**
 *
 * @author odieng
 */
@Named(value = "categoryMB")
@RequestScoped
public class CategoryMB {

    @EJB
    private CategoriesFacadeLocal categoriesFacade;
    private Categories categories;
    private String categoryName;
    private String categoryDescription;
    private Long categoryID;

    /**
     * Creates a new instance of CategoryMB
     */
    public CategoryMB() {
        categories = new Categories();
    }

    public List<Categories> showAllCategories() {
        return categoriesFacade.findAll();
    }

    public String insertCategories() {
        categoriesFacade.create(categories);
        return "displayCategory";
    }

    public String showUpdateCategory(Long id) {
        categories = categoriesFacade.find(id);
        categoryID = categories.getCategoryID();
        return "updateCategory";
    }

    public String saveUpdateCategories() {
        categoriesFacade.edit(categories);
        return "displayCategory";
    }

    public String deleteCategories(Long id) {
        categoriesFacade.remove(categoriesFacade.find(id));
        return "displayCategory";
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Long getIdCate() {
        return categoryID;
    }

    public void setIdCate(Long idCate) {
        this.categoryID = idCate;
    }

    public CategoriesFacadeLocal getCategoriesFacade() {
        return categoriesFacade;
    }

    public void setCategoriesFacade(CategoriesFacadeLocal categoriesFacade) {
        this.categoriesFacade = categoriesFacade;
    }

}
