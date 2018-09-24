package com.capgemini.sdv.model;

public class BattleItem {
    private String name;
    private int bonusAttack;
    private int bonusDefense;

    public BattleItem(String name, int bonusAttack, int bonusDefense) {
        this.name = name;
        this.bonusAttack = bonusAttack;
        this.bonusDefense = bonusDefense;
    }
}
