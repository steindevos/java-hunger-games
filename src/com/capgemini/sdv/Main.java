package com.capgemini.sdv;

import com.capgemini.sdv.controller.ArenaController;
import com.capgemini.sdv.controller.GameController;

public class Main {

    public static void main(String[] args) {

        GameController gameController = new GameController();

        gameController.startGame();
    }
}
//Rick's advise: Try ... Catch
