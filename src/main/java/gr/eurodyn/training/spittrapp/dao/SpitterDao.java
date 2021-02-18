package gr.eurodyn.training.spittrapp.dao;

import gr.eurodyn.training.spittrapp.domain.Spitter;
import gr.eurodyn.training.spittrapp.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpitterDao {
    static Session session;
    public final static Logger logger = Logger.getLogger(SpitterDao.class);

    public void create(Spitter spitter){
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

    public static List<Spitter> display() {
        List<Spitter> spittersList = new ArrayList<>();
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

    public void update(Long id){
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

    public void delete(Long id) {
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
//        Spitter findSpitter = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
//            findSpitter = (Spitter) session.load(Spitter.class, id);

        }catch (Exception e){
            if(session.getTransaction() !=null){
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return (Spitter) session.load(Spitter.class, id);
    }
}
