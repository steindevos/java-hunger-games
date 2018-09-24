package com.capgemini.sdv.model;

// Districts: strong defense/weak offense
public class District extends Contestant {

    int defenseLevel = super.getDefenseLevel() + 20;

    @Override
    public int getDefenseLevel() {
        return defenseLevel;
    }

    @Override
    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    @Override
    void specialAttack() {
        int specialAttack = 30;
    }
}
