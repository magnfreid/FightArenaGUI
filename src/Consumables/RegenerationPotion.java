package Consumables;
import Fighter.Fighter;

public class RegenerationPotion extends Consumable implements UseConsumable{
    final private int healing;
    final private int duration;

    public RegenerationPotion(String name) {
        super(name);
        healing = 20;
        duration = 4;
    }

    @Override
    public void useConsumable(Fighter fighter) {
      fighter.setHealth(fighter.getHealth() + healing);
        System.out.println(fighter.getName() + " used " + name +"!");
        System.out.println(fighter.getName() + " now has " +fighter.getHealth() +" health.");
    }
}
