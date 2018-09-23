package com.capgemini.sdv.model;

import java.util.concurrent.ThreadLocalRandom;


// Contestant parent class; Contestants are spawned in the Arena and have to fight till one lasts.
public class Contestant {
    private String name;
    private boolean male;

    private int defenseLevel = 10;
    private int attackLevel = 10;
    private int luckLevel = ThreadLocalRandom.current().nextInt(0, 30);




    // setters and getters
    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
}
