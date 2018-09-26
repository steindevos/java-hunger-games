package com.capgemini.sdv;

import com.capgemini.sdv.controller.ArenaController;

public class Main {
    public static void main(String[] args) {
        ArenaController arena = new ArenaController();
//      commander snow must be able to place a bet on a Contestant
        arena.createPlayers();
        arena.dropBattleItems();
        boolean gameMode = true;
        while(gameMode) {
            int choice = arena.gameMenu();
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
                    System.out.println("Thank your for playing, Mr. Snow");
                    break;
                default: System.out.println("no valid input; please enter a number");
            }
        }
    }
}
