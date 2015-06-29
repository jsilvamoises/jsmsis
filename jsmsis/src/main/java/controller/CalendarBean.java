/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author MOISES
 */
@ManagedBean
@RequestScoped
public class CalendarBean implements Serializable{
    private int  ano;

    public int getAno() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
