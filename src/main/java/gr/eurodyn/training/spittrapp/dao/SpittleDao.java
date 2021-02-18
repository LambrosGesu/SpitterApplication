package gr.eurodyn.training.spittrapp.dao;

import gr.eurodyn.training.spittrapp.domain.Spittle;
import gr.eurodyn.training.spittrapp.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

public class SpittleDao {
    static Session session;
    public final static Logger logger = Logger.getLogger(SpitterDao.class);


    public void create(Spittle spittle) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(spittle);
            logger.info("\nSpitter Created");
        }catch (Exception e){
            if(null != session.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List display() {
        List spittlesList = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            logger.info("\nAll Spittles\n");
            spittlesList = session.createQuery("FROM Spittle").list();
        } catch(Exception e) {
            if(null != session.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return spittlesList;
    }

    public void update(Long id) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Spittle spittle = (Spittle) session.get(Spittle.class, id);
            spittle.setMessage("A new updated message");
            session.getTransaction().commit();
            logger.info("\nSpittle Updated");
        }catch (Exception e) {
            if(null != session.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public void delete(Long id) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Spittle spittle = findSpittleById(id);
            session.delete(spittle);
            session.getTransaction().commit();
            logger.info("\nSpittle with Id = " + id + " Deleted");
        }catch (Exception e){
            if(null != session.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public static Spittle findSpittleById(Long id){
        Spittle findSpittle = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            findSpittle = (Spittle) session.load(Spittle.class, id);
        }catch (Exception e){
            if(session.getTransaction() !=null){
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return findSpittle;
    }
}
