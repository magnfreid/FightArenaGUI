package Game;

import Champion.Champion;
import Champion.Classes.Mage;
import Champion.Classes.Rogue;
import Champion.Classes.Warrior;
import Gear.Armor;
import Gear.Weapon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arena {
    final private ArrayList<Weapon> weapons = Setup.loadWeapons();
    final private ArrayList<Armor> armors = Setup.loadArmors();
    // final private ArrayList<Consumable> consumables = Setup.loadConsumables();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public void gameLoop() throws InterruptedException {
        System.out.println("Welcome to the arena!");
        System.out.println("***** Champion one *****");
        System.out.println("Enter the class of the first champion. Pick between Mage, Rogue and Warrior.");
        String input = scanner.nextLine();
        Champion champion1 = createChampion(input);
        System.out.println("***** Champion two *****");
        System.out.println("Enter the class of the second champion. Pick between Mage, Rogue and Warrior.");
        input = scanner.nextLine();
        Champion champion2 = createChampion(input);
        System.out.println("It's " + champion1.getClass() + " vs. " + champion2.getClass() + "!!!");
        Champion winner = fight(champion1, champion2);
        //TODO lägg till reseten av game loopen (kör till någon når max level)
    }

    //Chans att plocka upp ett bättre vapen var tredje runda + bättre armor för den med minst liv...
    public Champion fight(Champion champion1, Champion champion2) throws InterruptedException {
        Champion winner;
        armFighters(champion1, champion2);
        armorFighters(champion1, champion2);
        //TODO snygga till printen
        System.out.println(champion1);
        System.out.println(champion2);
        int round = 1;
        while (champion1.isAlive() && champion2.isAlive()) {
            System.out.println("\n*****---------*****");
            System.out.println("Round: " + round);
            System.out.println();
            if (round % 3 == 0) {
                armFighters(champion1, champion2);
                if (champion1.getHealth() > champion2.getHealth()) {
                    champion2.pickUpArmor(getRandomArmor());
                } else if (champion1.getHealth() < champion2.getHealth()) {
                    champion1.pickUpArmor(getRandomArmor());
                }
            }
            if (champion1.isAlive() && champion2.isAlive()) {
                turn(champion1, champion2);
            }
            if (champion1.isAlive() && champion2.isAlive()) {
                turn(champion2, champion1);
            }
            round++;
        }
        if (champion1.isAlive()) {
            System.out.println(champion1.getName() + " wins the fight and gains 1 level!");
            champion1.levelUp();
            winner = champion1;
        } else {
            System.out.println(champion2.getName() + " wins the fight and gains 1 level!");
            champion2.levelUp();
            winner = champion2;
        }
        winner.dropArmor();
        winner.dropWeapon();
        return winner;
    }

    private void turn(Champion attacker, Champion defender) throws InterruptedException {
        endSpecialPower(attacker);
        rollSpecialPower(attacker);
        Thread.sleep(2000);
        attacker.attack(defender);
    }

    private void rollSpecialPower(Champion champion) {
        int specialPowerRoll = Dice.roll20();
        System.out.println();
        System.out.println(champion.getName() + " specialPowerRoll = " + specialPowerRoll);
        if (specialPowerRoll > 18) {
            champion.setSpecialPowerActive(true);
            int randomPower = random.nextInt(0, (champion.getSpecialPowers().size()));
            champion.setActivePowerIndex(randomPower);
            champion.getSpecialPowers().get(randomPower).activatePower();
        }
    }


    private Champion createChampion(String input) {
        Champion champion = null;
        switch (input.toLowerCase()) {
            case "mage": {
                System.out.println("You picked mage. Enter a name:");
                String name = scanner.nextLine();
                champion = new Mage(name);
                break;
            }
            case "rogue": {
                System.out.println("You picked rogue. Enter a name:");
                String name = scanner.nextLine();
                champion = new Rogue(name);
                break;
            }
            case "warrior": {
                System.out.println("You picked warrior. Enter a name:");
                String name = scanner.nextLine();
                champion = new Warrior(name);
                break;
            }
            default: {
                System.out.println("Wrong input, try again!");
            }
        }
        return champion;
    }

    private void endSpecialPower(Champion champion) {
        if (champion.isSpecialPowerActive()) {
            champion.getSpecialPowers().get(champion.getActivePowerIndex()).deactivatePower();
            champion.setSpecialPowerActive(false);
        }
    }

    private Armor getRandomArmor() {
        return armors.get(random.nextInt(armors.size()));
    }

    private void armFighters(Champion champion1, Champion champion2) {
        champion1.pickUpWeapon(getRandomWeapon());
        champion2.pickUpWeapon(getRandomWeapon());
    }

    private Weapon getRandomWeapon() {
        return weapons.get(random.nextInt(weapons.size()));
    }

    private void armorFighters(Champion champion1, Champion champion2) {
        champion1.pickUpArmor(getRandomArmor());
        champion2.pickUpArmor(getRandomArmor());
    }


}
