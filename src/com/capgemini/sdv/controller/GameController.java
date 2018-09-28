package com.capgemini.sdv.controller;

import com.capgemini.sdv.model.Contestant;

import java.util.Scanner;

public class GameController {
    public void startGame() {
        ArenaController arena = new ArenaController();
//      commander snow must be able to place a bet on a Contestant
        arena.createPlayers();
        arena.dropBattleItems();
        System.out.println("Welcome, President Snow. Ready to play your favorite game?");
        boolean gameMode = true;
        while(gameMode) {
            int choice = gameMenu();
            switch (choice) {
                case 1: arena.battleTillOneLasts();
                    break;
                case 2: arena.battleToDeath();
                    arena.nightTime();
                    break;
                case 3: arena.addBattleItem();
                    break;
                case 4: arena.getStatusAllPlayers();
                    break;
                case 5: arena.getAllBattleItems();
                    break;
                case 6: gameMode = false;
                    break;
                default: System.out.println("no valid input; please enter a number");
            }
        }
        System.out.println("Thank your for playing, President Snow. Until next time.");
    }


    public int gameMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("----------MENU----------");
        System.out.println("1.  Play all rounds in one go");
        System.out.println("2.  Play one round");
        System.out.println("3.  Add battle item");
        System.out.println("4.  Get status of all contestants");
        System.out.println("5.  Get all battle items in game");
        System.out.println("6.  Exit game");
        System.out.println("------------------------");
        int choice = Integer.parseInt(in.nextLine());
        return choice;
    }

    public void presentWinner(Contestant contestant) {
        System.out.println("----------WINNER----------");
        System.out.println("The winner of this round of the Hunger games is " + contestant.getName());
        contestant.getStats();
        System.out.println("--------------------------");
    }


}
