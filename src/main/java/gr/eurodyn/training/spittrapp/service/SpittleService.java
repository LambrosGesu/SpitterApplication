package gr.eurodyn.training.spittrapp.service;

import gr.eurodyn.training.spittrapp.dao.SpittleDao;
import gr.eurodyn.training.spittrapp.domain.Spittle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
