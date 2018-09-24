package com.capgemini.sdv.model;

// Career: strong offense/weak defense
public class Career extends Contestant {
    int attackLevel = super.getAttackLevel() + 5;


    @Override
    public int getAttackLevel() {
        return attackLevel;
    }

    @Override
    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    @Override
    int specialAttack() {
        int attackLevel = getAttackLevel() + 20;
        int damageDone = attackLevel * getLuckLevel();
        return damageDone;
    }
}
