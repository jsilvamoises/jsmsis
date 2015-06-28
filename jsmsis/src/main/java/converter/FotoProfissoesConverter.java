/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import model.FotoProfissoes;
import repository.FotoProfissoesRepository;

/**
 *
 * @author MOISES
 */
@FacesConverter(forClass = FotoProfissoes.class)
public class FotoProfissoesConverter implements javax.faces.convert.Converter {

    FotoProfissoesRepository repository = new repository.FotoProfissoesRepository();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        FotoProfissoes objeto = null;
        
        if (value != null) {
            try {
                Long id = new Long(value);
                objeto = (FotoProfissoes) repository.getEntity(id);
            } catch (Exception e) {
                // FacesUtil.addErrorMessage(e.getCause().getMessage());
            } finally {
                
            }

        }
        return objeto;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long id = ((FotoProfissoes) value).getId();
            return String.valueOf(id);
        }
        return "";
    }

}
