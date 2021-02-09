import domain.Spitter;
import domain.Spittle;
import service.SpitterService;
import service.SpittleService;

import java.util.List;

public class SpittrApplication {

    public static void main(String[] args) {

        SpitterService spitterService = new SpitterService();
        SpittleService spittleService = new SpittleService();

        Spitter s1 = new Spitter (1L,"Lambros","Gesoulis","lgeso", "pass123");
        Spitter s2 = new Spitter (2L,"John","Gesoulis","lgeso", "pass321");
        Spitter s3 = new Spitter (3L,"George","Gesoulis","lgeso", "pass1234");
        Spitter s4 = new Spitter (4L,"Jim","Gesoulis","lgeso", "pass4321");

        Spittle sl1 = new Spittle(1L, "A small message", "2020-02-09");
        Spittle sl2 = new Spittle(1L, "A small message", "2020-02-09");
        Spittle sl3 = new Spittle(1L, "A small message", "2020-02-09");
        Spittle sl4 = new Spittle(1L, "A small message", "2020-02-09");

        spitterService.createSpitter(s1);
        spitterService.createSpitter(s2);
        spitterService.createSpitter(s3);
        spitterService.createSpitter(s4);

        spittleService.createSpittle(sl1);
        spittleService.createSpittle(sl2);
        spittleService.createSpittle(sl3);
        spittleService.createSpittle(sl4);

        List<Spittle> listOfSpittles = spittleService.getSpittles();
        s1.setSpittles(listOfSpittles);

        spitterService.deleteSpitter(s3);
        spitterService.deleteSpitter(s2);

        System.out.println(spitterService.getSpitters());
        System.out.println(spittleService.getSpittles());
    }

}
