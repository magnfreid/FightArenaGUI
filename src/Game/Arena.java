package Game;

import Fighter.Fighter;
import Items.Armor;
import Items.Consumable;
import Items.Weapon;

import java.util.ArrayList;
import java.util.Random;

public class Arena {
    final private ArrayList<Weapon> weapons = Setup.loadWeapons();
    final private ArrayList<Armor> armors = Setup.loadArmors();
    final private ArrayList<Consumable> consumables = Setup.loadConsumables();
    Random random = new Random();

    public void fight(Fighter fighter1, Fighter fighter2) throws InterruptedException {


        fighter1.pickUpWeapon(weapons.get(random.nextInt(weapons.size())));
        fighter2.pickUpWeapon(weapons.get(random.nextInt(weapons.size())));
        fighter1.pickUpArmor(armors.get(random.nextInt(armors.size())));
        fighter2.pickUpArmor(armors.get(random.nextInt(armors.size())));


        while (fighter1.getHealth() > 0 && fighter2.getHealth() > 0) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            fighter1.attack(fighter2);
            Thread.sleep(2000);
            fighter2.attack(fighter1);

        }
    }


}
