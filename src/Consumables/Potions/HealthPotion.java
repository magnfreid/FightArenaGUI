package Consumables.Potions;

import Champion.Champion;

public class HealthPotion implements InstantPotion {

    String name;
    int healAmount;

    public HealthPotion(String name, int healAmount) {
        this.name = name;
        this.healAmount = healAmount;
    }


    @Override
    public void drinkPotion(Champion champion, int effect) {

    }
}
