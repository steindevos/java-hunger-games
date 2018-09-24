package com.capgemini.sdv.model;

// Districts: strong defense/weak offense
public class District extends Contestant {

    int defenseLevel = super.getDefenseLevel() + 10;

    @Override
    public int getDefenseLevel() {
        return defenseLevel;
    }

    @Override
    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    @Override
    int specialAttack() {
        int attackLevel = getAttackLevel() + 20;
        int damageDone = attackLevel * getLuckLevel();
        return damageDone;
    }
}
