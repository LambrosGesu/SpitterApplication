package service;

import dao.SpitterDao;
import domain.Spitter;

import java.util.ArrayList;
import java.util.List;

public class SpitterService {
    private SpitterDao spitterDao = new SpitterDao();

    public SpitterService() {
    }

    public void createSpitter(Spitter spitter){
        spitterDao.create(spitter);
    }

    public void deleteSpitter(Spitter spitter){
        spitterDao.delete(spitter.getId());
    }

    public void updateSpitter(Spitter spitter) {
        spitterDao.update(spitter.getId());
    }

    public List getSpitters(){
        return spitterDao.display();
    }

    public Spitter findSpitter(Long id){
        return spitterDao.findSpitterById(id);
    }

}
