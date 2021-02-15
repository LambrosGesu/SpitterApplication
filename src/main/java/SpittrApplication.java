import dao.SpitterDao;
import domain.Spitter;
import domain.Spittle;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.SpitterService;

import javax.security.auth.login.Configuration;
import java.util.List;

public class SpittrApplication {

    public static void main(String[] args) throws Exception {

        SpitterService spitterService = new SpitterService();
        Spitter spitter1 = new Spitter("lambros", "Gesoulis", "lgeso", "pass123");
        Spitter s2 = new Spitter("john", "Gesoulis", "lgeso", "pass123");
        Spitter s3 = new Spitter("george", "Gesoulis", "lgeso", "pass123");
        Spitter s4 = new Spitter("Tom", "Gesoulis", "lgeso", "pass123");

        Spittle stl1 = new Spittle("A small message", "12/12/2012", spitter1);
        Spittle stl2 = new Spittle("A second small message", "14/05/2021", s2);
        Spittle stl3 = new Spittle("A third small message", "16/02/2021", s3);

        spitterService.createSpitter(spitter1);
        spitterService.createSpitter(s2);
        spitterService.createSpitter(s3);
        spitterService.createSpitter(s4);
        spitterService.getSpitters();
        spitterService.deleteSpitter(spitter1);
        spitterService.updateSpitter(s3);
        spitterService.getSpitters();

    }

}
