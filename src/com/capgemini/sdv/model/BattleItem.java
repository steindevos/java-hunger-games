package com.capgemini.sdv.model;

public class BattleItem {
    private String type;
    private int bonusAttack;
    private int bonusDefense;

    public BattleItem(String type, int bonusAttack, int bonusDefense) {
        this.type = type;
        this.bonusAttack = bonusAttack;
        this.bonusDefense = bonusDefense;
    }

    public String getType() {
        return type;
    }

    public int getBonusAttack() {
        return bonusAttack;
    }

    public int getBonusDefense() {
        return bonusDefense;
    }

}
