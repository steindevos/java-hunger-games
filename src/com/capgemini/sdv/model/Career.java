package com.capgemini.sdv.model;

// Career: strong offense/weak defense
public class Career extends Contestant {
    int attackLevel = super.getAttackLevel() + 10;


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
        int damageDone = 80;
        System.out.println("WOOOWWW, SPECIAL ATTACK!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        return damageDone;
    }
}
