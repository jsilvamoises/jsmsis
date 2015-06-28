/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author MOISES
 */
@ManagedBean
@RequestScoped
public class IntergerBean {
    private List<Integer> inteiros = new ArrayList<>();

    public IntergerBean() {
        for(int i =0; i< 8; i++){
            inteiros.add(i);
        }
    }

    public List<Integer> getInteiros() {
        return inteiros;
    }

    public void setInteiros(List<Integer> inteiros) {
        this.inteiros = inteiros;
    }
    
    
    
    
}
