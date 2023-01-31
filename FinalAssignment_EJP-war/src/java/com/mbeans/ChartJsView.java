/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author odieng
 */
@Named(value = "chartJsView")
@RequestScoped
public class ChartJsView {

    /**
     * Creates a new instance of ChartJsView
     */
    public ChartJsView() {
    }
    
}
