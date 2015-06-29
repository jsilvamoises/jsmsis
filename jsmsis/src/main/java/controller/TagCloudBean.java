/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ApplicationScoped
public class TagCloudBean {
    private TagCloudModel model;
     
    @PostConstruct
    public void init() {
        model = new DefaultTagCloudModel();
        model.addTag(new DefaultTagCloudItem("PEDREIRO", 1));
        model.addTag(new DefaultTagCloudItem("PROGRAMADOR", "#", 3));
        model.addTag(new DefaultTagCloudItem("MANICURE", 2));
        model.addTag(new DefaultTagCloudItem("CUSTUREIRA", "#", 5));
        model.addTag(new DefaultTagCloudItem("MAQUIADORA", 4));
        model.addTag(new DefaultTagCloudItem("ELETRICISTA", "#", 2));
        model.addTag(new DefaultTagCloudItem("FERRAMENTEIRO", 5));
        model.addTag(new DefaultTagCloudItem("JARDINEIRO",  3));
        model.addTag(new DefaultTagCloudItem("CARPINTEIRO", "#", 4));
        model.addTag(new DefaultTagCloudItem("MASSAGISTA", "#", 1));
    }
 
    public TagCloudModel getModel() {
        return model;
    }
     
    public void onSelect(SelectEvent event) {
        TagCloudItem item = (TagCloudItem) event.getObject();
        try {
            //FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", item.getLabel());
            // FacesContext.getCurrentInstance().addMessage(null, msg);
            FacesContext.getCurrentInstance().getExternalContext().redirect("http://www.google.com.br/item");
        } catch (IOException ex) {
            Logger.getLogger(TagCloudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
