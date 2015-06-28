/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import model.PessoaFisica;

import util.JpaUtil;

/**
 *
 * @author MOISES
 */
@FacesConverter(forClass = PessoaFisica.class)
public class PessoaFisicaConverter implements javax.faces.convert.Converter {

    EntityManager manager;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        PessoaFisica objeto = null;
        manager = JpaUtil.getEntityManager();
        if (value != null) {
            try {
                Long id = new Long(value);
                objeto = manager.find(PessoaFisica.class, id);
            } catch (Exception e) {
                // FacesUtil.addErrorMessage(e.getCause().getMessage());
            } finally {
                manager.close();
            }

        }
        return objeto;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long id = ((PessoaFisica) value).getId();
            return String.valueOf(id);
        }
        return "";
    }

}
