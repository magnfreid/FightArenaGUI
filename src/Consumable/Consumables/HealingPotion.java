package Consumable.Consumables;
import Consumable.UseConsumable;
import Champion.Champion;
import Consumable.Consumable;

public class HealingPotion extends Consumable implements UseConsumable {
    final private int healing;
    public HealingPotion(String name) {
        super(name);
        this.healing = 50;
    }

    @Override
    public void useConsumable(Champion champion) {
        champion.setHealth(champion.getHealth() + healing);
        System.out.println(champion.getName() + " used " + name +"!");
        System.out.println(champion.getName() + " now has " + champion.getHealth() +" health.");
    }
}
