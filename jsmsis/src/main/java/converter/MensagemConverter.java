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
import model.Mensagem;
import repository.MensagemRepository;
import util.JpaUtil;

/**
 *
 * @author MOISES
 */
@FacesConverter(forClass = Mensagem.class)
public class MensagemConverter implements javax.faces.convert.Converter {

    MensagemRepository repository = new MensagemRepository();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Mensagem objeto = null;
       
        if (value != null) {
            try {
                Long id = new Long(value);
                objeto = (Mensagem) repository.getEntity(id);
            } catch (Exception e) {
                // FacesUtil.addErrorMessage(e.getCause().getMessage());
            } finally {
                System.gc();
            }

        }
        return objeto;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long id = ((Mensagem) value).getId();
            return String.valueOf(id);
        }
        return "";
    }

}
