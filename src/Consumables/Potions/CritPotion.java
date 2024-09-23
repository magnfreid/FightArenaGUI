package Consumables.Potions;

import Champion.Champion;
import Consumables.Consumable;

public class CritPotion extends Consumable implements DurationPotion {


    public CritPotion(String name, int effect) {
        super(name, effect);
    }

    @Override
    public void drinkPotion(Champion champion, int effect, int duration) {

    }
}
