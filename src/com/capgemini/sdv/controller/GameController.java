package com.capgemini.sdv.controller;

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
                case 1: arena.battleToDeath();
                    arena.nightTime();
                    break;
                case 2: arena.addBattleItem();
                    break;
                case 3: arena.getStatusAllPlayers();
                    break;
                case 4: arena.getAllBattleItems();
                    break;
                case 5: gameMode = false;
                    break;
                default: System.out.println("no valid input; please enter a number");
            }
        }
        System.out.println("Thank your for playing, President Snow. Until next time.");
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
