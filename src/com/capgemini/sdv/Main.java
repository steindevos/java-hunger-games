package com.capgemini.sdv;

import com.capgemini.sdv.controller.ArenaController;
import com.capgemini.sdv.model.Contestant;

public class Main {

    public static void main(String[] args) {
        ArenaController arena = new ArenaController();

        arena.createPlayers();

        while (arena.getContestants().size() > 1) {
            arena.battleToDeath();
            arena.nightTime();
        }
    }
}
