/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import dao.Dao;
import interfaces.InterfaceDao;
import java.io.Serializable;
import java.util.List;
import model.Mensagem;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author MOISES
 */
public class MensagemRepository implements Serializable, interfaces.InterfaceDao {
    
    private InterfaceDao<Mensagem> Dao() {
        InterfaceDao<Mensagem> dao = new Dao<>(Mensagem.class);
        return dao;
    }

    @Override
    public boolean save(Object entity) {
        return Dao().save((Mensagem)entity);
    }

    @Override
    public boolean saveOrUpdate(Object entity) {
        return Dao().saveOrUpdate((Mensagem)entity);
    }

    @Override
    public boolean update(Object entity) {
       return Dao().update((Mensagem)entity);
    }

    @Override
    public boolean remove(Object entity) {
        return Dao().remove((Mensagem)entity);
    }

    @Override
    public boolean merge(Object entity) {
        return Dao().merge((Mensagem)entity);
    }

    @Override
    public Object getEntity(Serializable id) {
        return Dao().getEntity(id);
    }

    @Override
    public Object getEntityByDetachedCriteria(DetachedCriteria criteria) {
        return Dao().getEntityByDetachedCriteria(criteria);
    }
    
    
    public List<Mensagem> mensagensUsuario(Usuario u){
        DetachedCriteria criteria = DetachedCriteria.forClass(Mensagem.class);
        criteria.add(Restrictions.eq("from", u));
        return Dao().getEntitiesByDetachetCriteria(criteria);
    }

    @Override
    public List getEntities() {
        return Dao().getEntities();
    }

    @Override
    public List getEntitiesTop(int top, String campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getEntitiesByDetachetCriteria(DetachedCriteria criteria) {
         return Dao().getEntitiesByDetachetCriteria(criteria);
    }

    @Override
    public List getEntitiesByQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commit(Session session) {
        session.getTransaction().commit();
    }

    @Override
    public void rollback(Session session) {
        session.getTransaction().rollback();
    }

    @Override
    public void begin(Session session) {
        session.getTransaction().begin();
    }

    @Override
    public Session getSession() {
         return Dao().getSession();
    }

    @Override
    public List getTop(int totalRest, String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public List entitiesTopByDetachedCriteria(int max, DetachedCriteria criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
