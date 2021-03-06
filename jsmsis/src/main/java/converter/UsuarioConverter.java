/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import model.Usuario;
import repository.UsuarioRepository;

/**
 *
 * @author MOISES
 */
@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements javax.faces.convert.Converter {

    UsuarioRepository repository = new UsuarioRepository();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Usuario objeto = null;
        
        if (value != null) {
            try {
                
               // Long id = new Long(value);
                objeto = repository.getUsuarioByLogin(value);
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
            Long id = ((Usuario) value).getId();
            return String.valueOf(id);
        }
        return "";
    }

}
