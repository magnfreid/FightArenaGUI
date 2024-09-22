package Consumable.Consumables;

import Consumable.Consumable;

public class ShieldPotion extends Consumable {
    final private int armorBonus;
    final private int duration;
    public ShieldPotion(String name) {
        super(name);
        armorBonus = 100;
        duration = 2;
    }

    public int getArmorBonus() {
        return armorBonus;
    }

    public int getDuration() {
        return duration;
    }
}
