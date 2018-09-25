package com.capgemini.sdv.controller;

import com.capgemini.sdv.model.BattleItem;
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
    // List of battle items
    private ArrayList<BattleItem> battleItems = new ArrayList<>();

    // Getters and setters
    public ArrayList<Contestant> getContestants() {
        return contestants;
    }

    public ArrayList<Contestant> getDeadContestants() {
        return deadContestants;
    }

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



    // two random players battle till one dies. Winner gains bonus attack and defense. Dead contestants are removed from contestants and added to deadcontestants
    public void battleToDeath() {
        Contestant player1 = contestants.get(ThreadLocalRandom.current().nextInt(0, contestants.size()));
        contestants.remove(player1);
        Contestant player2 = contestants.get(ThreadLocalRandom.current().nextInt(0, contestants.size()));
        contestants.remove(player2);

        System.out.println(player1.getName() + " and " + player2.getName() + " enter into battle.");
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            player1.attack(player2);
            if (player2.getHealth() > 0) {
                player2.attack(player1);
            } else {
                deadContestants.add(player2);
                contestants.remove(player2);
                contestants.add(player1);
                player1.gainExperience();
            }
            if (player1.getHealth() <= 0) {
                deadContestants.add(player1);
                contestants.remove(player1);
                contestants.add(player2);
                player2.gainExperience();
            }
        }
    }

    // nighttime. During sleep all players regenarate
    public void nightTime() {
        // player finds battle item

        System.out.println("All players go to bed. Health is set back to 100 for all players");
        for (Contestant contestant : contestants) {
            contestant.sleep();
        }
    }
}
