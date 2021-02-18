package gr.eurodyn.training.spittrapp.service;

import gr.eurodyn.training.spittrapp.dao.SpitterDao;
import gr.eurodyn.training.spittrapp.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpitterService {

    @Autowired
    private SpitterDao spitterDao;

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

    public List<Spitter> getSpitters(){
        return spitterDao.display();
    }

    public Spitter findSpitter(Long id){
        return spitterDao.findSpitterById(id);
    }

}
