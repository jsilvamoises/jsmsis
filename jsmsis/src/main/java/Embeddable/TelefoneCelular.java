/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Embeddable;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author MOISES
 */
@Embeddable
public class TelefoneCelular implements Serializable {
    
    @Column(name = "telefone_celular_codigo_pais", length = 5)
    private String codigoPais;
    
    @Column(name = "telefone_celular_ddd", length = 5)
    private String DDD;
    
    @Column(name = "telefone_celular_numero", length = 20)
    private String numero;

    public TelefoneCelular() {
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
    
}
