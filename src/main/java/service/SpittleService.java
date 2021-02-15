package service;

import dao.SpittleDao;
import domain.Spittle;

import java.util.ArrayList;
import java.util.List;

public class SpittleService {
    private SpittleDao spittleDao = new SpittleDao();

    public void createSpittle(Spittle spittle){
        spittleDao.create(spittle);
    }

    public void deleteSpittle(Spittle spittle){
        spittleDao.delete(spittle.getId());
    }

    public void updateSpittle(Spittle spittle){
        spittleDao.update(spittle.getId());
    }

    public List<Spittle> getSpittles(){
        return spittleDao.display();
    }
}
