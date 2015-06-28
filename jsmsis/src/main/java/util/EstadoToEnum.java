/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import enums.EstadoEnum;

/**
 *
 * @author MOISES
 */
public class EstadoToEnum {
     private static  EstadoToEnum instance;
     public static EstadoToEnum getInstance(){
        return instance==null?instance =new EstadoToEnum():instance;
     }

    public  String getEstado(String s) {
        s = s.toUpperCase().trim();
        EstadoEnum estado = null;
        switch (s) {
            case "ac":
                estado = EstadoEnum.Acre;
                break;
            case "al":
                estado = EstadoEnum.Alagoas;
                break;
            case "ap":
                estado = EstadoEnum.Amapa;
                break;
            case "am":
                estado = EstadoEnum.Amazonas;
                break;
            case "ba":
                estado = EstadoEnum.Bahia;
                break;
            case "ce":
                estado = EstadoEnum.Ceara;
                break;
            case "df":
                estado = EstadoEnum.Distrito_Federal;
                break;
            case "es":
                estado = EstadoEnum.Espirito_Santo;
                break;
            case "go":
                estado = EstadoEnum.Goias;
                break;
            case "ma":
                estado = EstadoEnum.Maranhao;
                break;
            case "mt":
                estado = EstadoEnum.Mato_Grosso;
                break;
            case "ms":
                estado = EstadoEnum.Mato_Grosso_do_Sul;
                break;
            case "mg":
                estado = EstadoEnum.Minas_Gerais;
                break;
            case "pa":
                estado = EstadoEnum.Para;
                break;
            case "pb":
                estado = EstadoEnum.Paraiba;
                break;
            case "pr":
                estado = EstadoEnum.Parana;
                break;
            case "pe":
                estado = EstadoEnum.Pernambuco;
                break;
            case "pi":
                estado = EstadoEnum.Piaui;
                break;
            case "rj":
                estado = EstadoEnum.Rio_de_Janeiro;
                break;
            case "rn":
                estado = EstadoEnum.Rio_Grande_do_Norte;
                break;
            case "rs":
                estado = EstadoEnum.Rio_Grande_do_Sul;
                break;
            case "ro":
                estado = EstadoEnum.Rondonia;
                break;
            case "rr":
                estado = EstadoEnum.Roraima;
                break;
            case "sc":
                estado = EstadoEnum.Santa_Catarina;
                break;
            case "sp":
                estado = EstadoEnum.Sao_Paulo;
                break;
            case "se":
                estado = EstadoEnum.Sergipe;
                break;
            case "to":
                estado = EstadoEnum.Tocantins;
                break;
        }
        return estado.name();
    }

}
