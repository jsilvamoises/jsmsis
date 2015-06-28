/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.InterfaceDao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import util.FacesUtil;
import util.HibernateUtil;

/**
 *
 * @author Moises
 */
public class Dao<T> implements InterfaceDao<T>, Serializable {

    private static final Long SerialVersionUID = 1L;
    private Class<T> classe;

    public Dao(Class<T> classe) {
        this.classe = classe;
    }

    @Override
    public boolean save(T entity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {

            tx.begin();

            session.saveOrUpdate(entity);
            tx.commit();
            FacesUtil.addInfoMessage("Salvo com sucesso!!");
            return true;
        } catch (Exception e) {
            try {
                tx.rollback();
            } catch (Exception e2) {
                FacesUtil.addInfoMessage("Não foi possivel desfazer a transação!!!" + e2.getCause());
            }

            FacesUtil.addInfoMessage("Erro ao salvar!!!" + e.getCause());
            return false;
        } finally {
            if (session.isOpen()) {
                if (tx.isActive()) {
                    session.close();
                }

            }
            clearMemory();
        }

    }

    @Override
    public boolean saveOrUpdate(T entity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {

            session.getTransaction().begin();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
            FacesUtil.addInfoMessage("Salvo com sucesso!!");
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            FacesUtil.addInfoMessage("Erro ao salvar!!!" + e.getCause());
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
            clearMemory();
        }
    }

    @Override
    public boolean update(T entity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {

            session.getTransaction().begin();
            session.update(entity);
            session.getTransaction().commit();
            FacesUtil.addInfoMessage("Atualizado com sucesso!!");
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            FacesUtil.addInfoMessage("Erro ao atualizar!!!" + e);
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
            clearMemory();
        }
    }

    @Override
    public boolean remove(T entity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {

            session.getTransaction().begin();
            session.delete(entity);
            session.getTransaction().commit();
            FacesUtil.addInfoMessage("Removido com sucesso!!");
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            FacesUtil.addInfoMessage("Erro ao remover!!!" + e);
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
            clearMemory();
        }
    }

    @Override
    public boolean merge(T entity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {

            session.getTransaction().begin();
            session.merge(entity);
            session.getTransaction().commit();
            FacesUtil.addInfoMessage("Sincronizado com sucesso!!");
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            FacesUtil.addInfoMessage("Erro ao sincronizar!!!" + e);
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
            clearMemory();
        }
    }

    @Override
    public T getEntity(Serializable id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            T entity = (T) session.get(classe, id);
            return entity;
        } catch (Exception e) {
            return null;
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public T getEntityByDetachedCriteria(DetachedCriteria criteria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            T entity = (T) criteria.getExecutableCriteria(session).uniqueResult();
            return entity;
        } catch (Exception e) {
            return null;
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
            clearMemory();
        }
    }

    @Override
    public List<T> getEntities() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();

            Criteria criteria = session.createCriteria(classe);

            return criteria.list();
        } catch (Exception e) {

            return null;
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
            clearMemory();
        }
    }

    @Override
    public List<T> getEntitiesTop(int top, String campoOrdenar) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();

            Criteria criteria = session.createCriteria(classe)
                    .addOrder(Order.desc(campoOrdenar))
                    .setMaxResults(top);

            return criteria.list();
        } catch (Exception e) {

            return null;
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
            clearMemory();
        }
    }
    
    public List<T> entitiesTopByDetachedCriteria(int max, DetachedCriteria criteria){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            return criteria.getExecutableCriteria(session).setMaxResults(max).list();
        } catch (Exception e) {
            return null;
        }finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
            clearMemory();
        }
    }

    @Override
    public List<T> getEntitiesByDetachetCriteria(DetachedCriteria criteria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            List<T> lista = (List<T>) session.createCriteria(classe).list();
            return criteria.getExecutableCriteria(session).list();
        } catch (Exception e) {
            return null;
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
            clearMemory();
        }

    }

    @Override
    public List<T> getEntitiesByQuery(String query) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.getTransaction().begin();
            SQLQuery sql = session.createSQLQuery(query).addEntity(classe.getClass());
            // SQLQuery sql = session.createSQLQuery("select *, lower(convert(`disponibilidadeTrabalho` using utf8)) from tbl_usuario WHERE lower(disponibilidadeTrabalho)  like '%feira%'").addEntity(Usuario.class);

            return sql.list();
        } catch (Exception e) {

            return null;
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
            clearMemory();
        }
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
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public void commit(Session session) {
        session.getTransaction().commit();
    }

    @Override
    public List<T> getTop(int totalRest, String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void clearMemory() {
        System.gc();
    }

}
