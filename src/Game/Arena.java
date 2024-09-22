package Game;

import Fighter.Fighter;
import Gear.Armor;
import Gear.Weapon;

import java.util.ArrayList;
import java.util.Random;

public class Arena {
    final private ArrayList<Weapon> weapons = Setup.loadWeapons();
    final private ArrayList<Armor> armors = Setup.loadArmors();
    // final private ArrayList<Consumable> consumables = Setup.loadConsumables();
    Random random = new Random();

    //Chans att plocka upp ett bättre vapen var tredje runda + bättre armor för den med minst liv...
    public void fight(Fighter fighter1, Fighter fighter2) throws InterruptedException {
        armFighters(fighter1, fighter2);
        armorFighters(fighter1, fighter2);
        System.out.println(fighter1);
        System.out.println(fighter2);
        int round = 1;
        while (fighter1.isAlive() && fighter2.isAlive()) {
            System.out.println("\n*****---------*****");
            System.out.println("Round: " + round);
            System.out.println();
            if (round % 3 == 0) {
                armFighters(fighter1, fighter2);
                if (fighter1.getHealth() > fighter2.getHealth()) {
                    fighter2.pickUpArmor(getRandomArmor());
                } else if (fighter1.getHealth() < fighter2.getHealth()) {
                    fighter1.pickUpArmor(getRandomArmor());
                }
            }
            if (fighter1.isAlive() && fighter2.isAlive()) {
                endSpecialPower(fighter1);
                rollSpecialPower(fighter1);
                Thread.sleep(2000);
                fighter1.attack(fighter2);
            }
            if (fighter1.isAlive() && fighter2.isAlive()) {
                endSpecialPower(fighter2);
                rollSpecialPower(fighter2);
                Thread.sleep(2000);
                fighter2.attack(fighter1);
            }
            round++;
        }
    }

    private void rollSpecialPower(Fighter fighter) {
        int specialPowerRoll = random.nextInt(1, 21);
        System.out.println();
        System.out.println(fighter.getName() + " specialPowerRoll = " + specialPowerRoll);
        if (specialPowerRoll > 10) {
            fighter.setSpecialPowerActive(true);
            int randomPower = random.nextInt(0, (fighter.getSpecialPowers().size()));
            fighter.setActivePowerIndex(randomPower);
            fighter.getSpecialPowers().get(randomPower).activatePower();
        }
    }

    private void endSpecialPower(Fighter fighter) {
        if (fighter.isSpecialPowerActive()) {
            fighter.getSpecialPowers().get(fighter.getActivePowerIndex()).deactivatePower();
        }
    }

    private Armor getRandomArmor() {
        return armors.get(random.nextInt(armors.size()));
    }

    private void armFighters(Fighter fighter1, Fighter fighter2) {
        fighter1.pickUpWeapon(getRandomWeapon());
        fighter2.pickUpWeapon(getRandomWeapon());
    }

    private Weapon getRandomWeapon() {
        return weapons.get(random.nextInt(weapons.size()));
    }

    private void armorFighters(Fighter fighter1, Fighter fighter2) {
        fighter1.pickUpArmor(getRandomArmor());
        fighter2.pickUpArmor(getRandomArmor());
    }


}
