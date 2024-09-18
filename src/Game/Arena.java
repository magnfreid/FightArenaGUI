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


    //TODO add rounds with weapon and armor switch in between + chance to use consumables
    public void fight(Fighter fighter1, Fighter fighter2) throws InterruptedException {

        fighter1.pickUpWeapon(weapons.get(random.nextInt(weapons.size())));
        fighter2.pickUpWeapon(weapons.get(random.nextInt(weapons.size())));
        fighter1.pickUpArmor(armors.get(random.nextInt(armors.size())));
        fighter2.pickUpArmor(armors.get(random.nextInt(armors.size())));

        while (fighter1.isAlive() && fighter2.isAlive()) {
            if (fighter1.isAlive() && fighter2.isAlive()) {
                Thread.sleep(2000);
                fighter1.attack(fighter2);
            }

            if (fighter1.isAlive() && fighter2.isAlive()) {
                Thread.sleep(2000);
                fighter2.attack(fighter1);
            }
        }
    }


}
