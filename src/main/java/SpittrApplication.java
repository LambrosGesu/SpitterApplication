import dao.SpitterDao;
import domain.Spitter;
import domain.Spittle;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.security.auth.login.Configuration;
import java.util.List;

public class SpittrApplication {

    public static void main(String[] args) throws Exception {

        SpitterDao d1 = new SpitterDao();
        Spitter s1 = new Spitter("lambros", "Gesoulis", "lgeso", "pass123");
        Spitter s2 = new Spitter("john", "Gesoulis", "lgeso", "pass123");
        Spitter s3 = new Spitter("george", "Gesoulis", "lgeso", "pass123");
        Spitter s4 = new Spitter("Tom", "Gesoulis", "lgeso", "pass123");

        Spittle stl1 = new Spittle("A small message", "12/12/2012", s1);
        Spittle stl2 = new Spittle("A second small message", "14/05/2021", s2);
        Spittle stl3 = new Spittle("A third small message", "16/02/2021", s3);
        d1.createSpitter(s1);
        d1.createSpitter(s2);
        d1.createSpitter(s3);
        d1.createSpitter(s4);
        SpitterDao.displaySpitters();
        d1.deleteSpitter(9L);
        d1.updateSpitter(4L);
        SpitterDao.displaySpitters();

//        d1.openConnection();
//        d1.createSpitter(s1);
//        d1.createSpitter(s2);
//        d1.createSpitter(s3);
//        d1.readSpitters();
//        d1.createSpitter(s4);
//        d1.updateSpitter(s2,"Vasilis", "Ioannou");
//        d1.deleteSpitter("3");
//        d1.readSpitters();
//        d1.closeConnection();
    }

}
