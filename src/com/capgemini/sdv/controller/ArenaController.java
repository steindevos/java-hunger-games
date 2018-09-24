package com.capgemini.sdv.controller;

import com.capgemini.sdv.model.Career;
import com.capgemini.sdv.model.Contestant;
import com.capgemini.sdv.model.District;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// Class that sets up the Arena for battle
public class ArenaController {

    // list of 24 Contestants
    private ArrayList<Contestant> contestants = new ArrayList<>();
    // List of all dead Contestants
    private ArrayList<Contestant> deadContestants = new ArrayList<>();



    // Create 24 contestants
    Contestant contestant;
    public void createPlayers() {
        for (int i = 1; i <= 18; i++) {
            contestant = new District();
            contestant.setName("District"+i);
            if((i % 2) == 0) {
                contestant.setMale(false);
            }
            contestants.add(contestant);
        }

        for (int i = 1; i <= 6; i++) {
            contestant = new Career();
            contestant.setName("Career"+i);
            if((i % 2) == 0) {
                contestant.setMale(false);
            }
            contestants.add(contestant);
        }
    }

    public void getStatusAllPlayers() {
        for (Contestant contestant : contestants)
            System.out.println("Name: " + contestant.getName() +"\n"
                    + "Attack level: " + contestant.getAttackLevel() + "\n"
                    + "Defense level: " + contestant.getDefenseLevel() + "\n"
                    + "Health level: " + contestant.getHealth() + "\n"
                    + "Luck level: " + contestant.getLuckLevel() + "\n"
                    + "Sex: " +  (contestant.isMale() ? "Male" : "female") + "\n");
    }

    public void battle() {
        Contestant player1 = contestants.get(ThreadLocalRandom.current().nextInt(0, contestants.size()));
        Contestant player2 = contestants.get(ThreadLocalRandom.current().nextInt(0, contestants.size()));

        System.out.println(player1.getName());
        System.out.println(player2.getName());
    }
}
