package Consumables;
import Champion.Champion;

public class RegenerationPotion extends Consumable implements UseConsumable{
    final private int healing;
    final private int duration;

    public RegenerationPotion(String name) {
        super(name);
        healing = 20;
        duration = 4;
    }

    @Override
    public void useConsumable(Champion champion) {
      champion.setHealth(champion.getHealth() + healing);
        System.out.println(champion.getName() + " used " + name +"!");
        System.out.println(champion.getName() + " now has " + champion.getHealth() +" health.");
    }
}
