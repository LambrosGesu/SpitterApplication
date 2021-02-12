package service;

import domain.Spitter;

import java.util.ArrayList;
import java.util.List;

public class SpitterService {
    private List<Spitter> spitters = new ArrayList<Spitter>();
    private  Spitter spitter;

    public SpitterService() {
    }

    public void createSpitter(Spitter spitter){
        spitters.add(spitter);
    }

    public void deleteSpitter(Spitter spitter){
        if(spitter.getId() != null)
            spitters.remove(spitter);
    }

    public void updateSpitter(Spitter spitter) {
        for(Spitter s : spitters){
            if(s.getId() == spitter.getId()){
                s.setFirstname(spitter.getFirstname());
                s.setLastname(spitter.getLastname());
                s.setUsername(spitter.getUsername());
                s.setPassword(spitter.getPassword());
            }
        }
    }

    public List<Spitter> getSpitters(){
        return spitters;
    }

    public Spitter findSpitter(Long id){
        for(Spitter s : spitters){
            if(s.getId() == id) return s;
        }
        return null;
    }

}
