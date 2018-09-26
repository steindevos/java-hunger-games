package com.capgemini.sdv.controller;

import com.capgemini.sdv.model.BattleItem;
import com.capgemini.sdv.model.Career;
import com.capgemini.sdv.model.Contestant;
import com.capgemini.sdv.model.District;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
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

    public ArrayList<BattleItem> getBattleItems() {
        return battleItems;
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

    public void dropBattleItems() {
        BattleItem battleItem;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                battleItem = new BattleItem("Sword", 5, 0 );
            } else {
                battleItem = new BattleItem("shield", 0, 5);
            }
            battleItems.add(battleItem);
        }
    }

    public void addBattleItem() {
        Scanner in = new Scanner(System.in);

        System.out.println("Name of battle item: ");
        String name = in.nextLine();

        System.out.println("Attack bonus: ");
        int attackBonus = in.nextInt();

        System.out.println("Defense bonus: ");
        int defenseBonus = in.nextInt();

        BattleItem newBattleItem = new BattleItem(name, attackBonus, defenseBonus);
        battleItems.add(newBattleItem);
    }

    // All players have a chance every night of finding a battle item.
    public void findsBattleItem() {
        for (Contestant contestant : contestants) {
            int chance = ThreadLocalRandom.current().nextInt(0, 21);
            if (chance == 20) {
                int randomBattleItem = ThreadLocalRandom.current().nextInt(0, battleItems.size());
                BattleItem battleItem = battleItems.get(randomBattleItem);
                contestant.setAttackLevel(contestant.getAttackLevel() + battleItem.getBonusAttack());
                contestant.setDefenseLevel(contestant.getDefenseLevel() + battleItem.getBonusDefense());
                System.out.println(contestant.getName() + " has found a " + battleItem.getType() + " and gets " + battleItem.getBonusAttack() + " attack bonus and " + battleItem.getBonusDefense() + " defense bonus.");
            }
        }
    }

    public void getAllBattleItems() {
        System.out.println("-----Battle Items in the game-----\n");
        for (BattleItem battleItem : battleItems) {
            System.out.println("Name: " + battleItem.getType());
            System.out.println("Attack bonus: " + battleItem.getBonusAttack());
            System.out.println("Defense bonus: " + battleItem.getBonusDefense() + "\n");
        }
    }


    public void getStatusAllPlayers() {
        System.out.println("-----------------STATUS ALL PLAYERS------------------\n");
        for (Contestant contestant : contestants) {
            System.out.println(
                "Name: " + contestant.getName() +"\n"
                + "Attack level: " + contestant.getAttackLevel() + "\n"
                + "Defense level: " + contestant.getDefenseLevel() + "\n"
                + "Health level: " + contestant.getHealth() + "\n"
                + "Sex: " +  (contestant.isMale() ? "Male" : "female") + "\n");
        }
        System.out.println("-----------------------------------------------------\n");
    }



    // two random players battle till one dies. Winner gains bonus attack and defense. Dead contestants are removed from contestants and added to deadcontestants
    public void battleToDeath() {
        // checks if there is more than one player in the areana
        if (contestants.size() <= 1) {
            System.out.println("THE WINNER OF THE HUNGER GAMES IS: ");
            getStatusAllPlayers();
            return;
        }

        // picks two players at random
        Contestant player1 = contestants.get(ThreadLocalRandom.current().nextInt(0, contestants.size()));
        contestants.remove(player1);
        Contestant player2 = contestants.get(ThreadLocalRandom.current().nextInt(0, contestants.size()));
        contestants.remove(player2);

        // two players fight till one dies
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
        // player might find a battle item and get bonus
        findsBattleItem();
        // all players get full health
        System.out.println("All players go to bed. Health is set back to 100 for all players \n");
        for (Contestant contestant : contestants) {
            contestant.sleep();
        }
    }


    public int gameMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("----------MENU----------");
        System.out.println("1.  Next round");
        System.out.println("2.  Add battle item");
        System.out.println("3.  Get status of all contestants");
        System.out.println("4.  Get all battle items in game");
        System.out.println("5.  Exit game");
        System.out.println("------------------------");
        int choice = Integer.parseInt(in.nextLine());
        return choice;
    }

}
