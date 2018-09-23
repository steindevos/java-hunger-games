package com.capgemini.sdv.controller;

import com.capgemini.sdv.model.Career;
import com.capgemini.sdv.model.Contestant;
import com.capgemini.sdv.model.District;

import java.util.ArrayList;

// Class that sets up the Arena for the Contestants
public class ArenaController {

    // list of 24 Contestants
    private ArrayList<Contestant> contestants = new ArrayList<>();

    Contestant contestant;

    public void createPlayers() {
        for (int i = 1; i <= 18; i++) {
            contestant = new District();
            contestant.setName("District"+i);
            if(i % 2 == 0) {
                contestant.setMale(false);
            }
            contestants.add(contestant);
        }

        for (int i = 1; i <= 6; i++) {
            contestant = new Career();
            contestant.setName("Career"+i);
            if(i % 2 == 0) {
                contestant.setMale(false);
            }
            contestants.add(contestant);
        }
    }

    public void getStatusAllPlayers() {
        for (Contestant contestant : contestants)
            System.out.println(contestant.getName() +"\n" + contestant.getAttackLevel());
    }
}
