package com.capgemini.sdv.model;

import java.util.concurrent.ThreadLocalRandom;

// Contestant parent class; Contestants are spawned in the Arena and have to fight till one lasts.
public abstract class Contestant {
    // Fields
    private String name;
    private boolean male = true;

    private int health = 100;
    private int defenseLevel = 10;
    private int attackLevel = 10;
    private int luckLevel;


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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLuckLevel() {
        return luckLevel;
    }

    public void setLuckLevel(int luckLevel) {
        this.luckLevel = luckLevel;
    }


    // Class methods
    public void sleep() {
        health = 100;
    }

    // Player attacks other player. Damage done is subtracted from health other player
    public void attack(Contestant player) {
        int doesSpecialAttack = ThreadLocalRandom.current().nextInt(1, 11);
        int damageDone;

        // sets damage done
        if (doesSpecialAttack == 10) {
            damageDone = specialAttack();
        } else {
            luckLevel = ThreadLocalRandom.current().nextInt(1, 5);
            damageDone = luckLevel * getAttackLevel() - player.getDefenseLevel();
            if (damageDone < 0) {
                damageDone = 0;
            }
        }
        // substracts damage from health and prints storyline
        System.out.println(getName() + " does " + damageDone + " damage to " + player.getName());
        player.setHealth(player.getHealth() - damageDone);
        if (player.getHealth() <= 0) {
            System.out.println(player.getName() + " was slain by " + getName());
        }
    }

    // players can gain exp when the win a fight
    public void gainExperience() {
        this.attackLevel = attackLevel + 5;
        this.defenseLevel = defenseLevel + 5;
        System.out.println(this.name + " has gained experience.");
    }

    // all childclasses of Contestant have their own special attack
    abstract int specialAttack();
}
