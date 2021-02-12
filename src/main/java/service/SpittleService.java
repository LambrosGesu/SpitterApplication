package service;

import domain.Spittle;

import java.util.ArrayList;
import java.util.List;

public class SpittleService {
    private List<Spittle> spittles = new ArrayList<Spittle>();

    public void createSpittle(Spittle spittle){
        spittles.add(spittle);
    }

    public void deleteSpittle(Spittle spittle){
        if(spittle.getId() != null)
            spittles.remove(spittle);
    }

    public void updateSpittle(Spittle spittle){
        for(Spittle s : spittles){
            if(s.getId() == spittle.getId()){
                s.setMessage(spittle.getMessage());
                s.setDate(spittle.getDate());
            }
        }
    }

    public List<Spittle> getSpittles(){
        if(spittles.isEmpty()){
            return null;
        }
        else {
            return spittles;
        }
    }
}
