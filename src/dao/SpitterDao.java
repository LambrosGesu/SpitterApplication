package dao;

import domain.Spitter;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

public class SpitterDao {
    static Session session;
    public final static Logger logger = Logger.getLogger(SpitterDao.class);

    public void createSpitter(Spitter spitter) throws Exception{
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(spitter);
            logger.info("\nSpitter with Name = " + spitter.getFirstname()+ " " + spitter.getLastname()+ " Created");
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

    public static List displaySpitters() {
        List spittersList = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            logger.info("\nAll Spitters\n");
            spittersList = session.createQuery("FROM Spitter").list();
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
        return spittersList;
    }

    public void updateSpitter(Long id) throws Exception {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Spitter spitter = (Spitter) session.get(Spitter.class, id);
            spitter.setFirstname("Theodore");
            spitter.setLastname("Stroh");
            session.getTransaction().commit();
            logger.info("\nSpitter with Id = " + id + " Updated");
        }
        catch (Exception e){
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

    public void deleteSpitter(Long id) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Spitter spitter = findSpitterById(id);
            session.delete(spitter);
            session.getTransaction().commit();
            logger.info("\nSpitter with Id = " + id + " Deleted");
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

    public static Spitter findSpitterById(Long id){
        Spitter findSpitter = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            findSpitter = (Spitter) session.load(Spitter.class, id);

        }catch (Exception e){
            if(session.getTransaction() !=null){
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return findSpitter;
    }
}
