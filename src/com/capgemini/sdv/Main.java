package com.capgemini.sdv;

import com.capgemini.sdv.controller.ArenaController;
import com.capgemini.sdv.model.BattleItem;
import com.capgemini.sdv.model.Contestant;

public class Main {

    public static void main(String[] args) {
        ArenaController arena = new ArenaController();

//        commander snow must be able to create battleitems
//        commander snow must be able to place a bet on a Contestant

        arena.createPlayers();
        arena.dropBattleItems();

        while (arena.getContestants().size() > 1) {
            arena.battleToDeath();
            arena.nightTime();
            arena.getStatusAllPlayers();
        }
    }
}
