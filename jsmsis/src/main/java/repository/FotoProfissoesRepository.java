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
import model.FotoProfissoes;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author MOISES
 */
public class FotoProfissoesRepository implements Serializable, interfaces.InterfaceDao {
    
    private InterfaceDao<FotoProfissoes> Dao() {
        InterfaceDao<FotoProfissoes> dao = new Dao<>(FotoProfissoes.class);
        return dao;
    }

    @Override
    public boolean save(Object entity) {
        return Dao().save((FotoProfissoes)entity);
    }

    @Override
    public boolean saveOrUpdate(Object entity) {
        return Dao().saveOrUpdate((FotoProfissoes)entity);
    }

    @Override
    public boolean update(Object entity) {
       return Dao().update((FotoProfissoes)entity);
    }

    @Override
    public boolean remove(Object entity) {
        return Dao().remove((FotoProfissoes)entity);
    }

    @Override
    public boolean merge(Object entity) {
        return Dao().merge((FotoProfissoes)entity);
    }

    @Override
    public Object getEntity(Serializable id) {
        return Dao().getEntity(id);
    }

    @Override
    public Object getEntityByDetachedCriteria(DetachedCriteria criteria) {
        return Dao().getEntityByDetachedCriteria(criteria);
    }

    @Override
    public List getEntities() {
        return Dao().getEntities();
    }
    
    public List Top8(){
        DetachedCriteria criteria = DetachedCriteria.forClass(FotoProfissoes.class);
        Criterion criterio = Restrictions.eq("iisFistPage", true);
        criteria.add(criterio);       
        return Dao().getEntitiesByDetachetCriteria(criteria);
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
    
    
    


}
