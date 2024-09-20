package Consumables;

import Fighter.Fighter;

public class HealingPotion extends Consumable implements UseConsumable {
    final private int healing;
    public HealingPotion(String name) {
        super(name);
        this.healing = 50;
    }

    @Override
    public void useConsumable(Fighter fighter) {
        fighter.setHealth(fighter.getHealth() + healing);
        System.out.println(fighter.getName() + " used " + name +"!");
        System.out.println(fighter.getName() + " now has " +fighter.getHealth() +" health.");
    }
}
