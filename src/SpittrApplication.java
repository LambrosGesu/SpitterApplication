import dao.SpitterDao;
import domain.Spitter;

public class SpittrApplication {

    public static void main(String[] args) throws Exception {

        SpitterDao d1 = new SpitterDao();
        Spitter s1 = new Spitter(1L,"lambros", "Gesoulis", "lgeso", "pass123");
        Spitter s2 = new Spitter(2L,"john", "Gesoulis", "lgeso", "pass123");
        Spitter s3 = new Spitter(3L,"george", "Gesoulis", "lgeso", "pass123");
        Spitter s4 = new Spitter(4L,"Tom", "Gesoulis", "lgeso", "pass123");
        d1.openConnection();
        d1.createSpitter(s1);
        d1.createSpitter(s2);
        d1.createSpitter(s3);
        d1.createSpitter(s4);
        d1.updateSpitter(s2,"Giannis", "Ioannou");
        d1.deleteSpitter("3");
        d1.readSpitters();
        d1.closeConnection();
    }

}
