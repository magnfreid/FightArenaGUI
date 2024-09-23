package Champion;

import Consumables.Consumable;
import Consumables.Potions.InstantPotion;
import Game.Dice;
import Gear.Armor;
import Gear.Weapon;

import java.util.ArrayList;
import java.util.Random;

public abstract class Champion implements Attacker {
    final protected String name;
    final static int MAX_LEVEL = 10;
    protected String championClass;
    protected int health = 100, level = 1, baseDamage = 10, baseArmor = 0, toCrit = 20, activePowerIndex = 0;
    protected double critBonusModifier = 1, levelUpHealthModifier = 1.05, levelUpDamageModifier = 1.15;
    protected Weapon weapon;
    protected Armor armor;
    private boolean isAlive = true, specialPowerActive = false;
    protected ArrayList<SpecialPower> specialPowers;
    private InstantPotion instantPotion;


    private Consumable consumable;

    public Champion(String name) {
        this.name = name;
        this.weapon = fists;
        this.armor = shirt;
    }

    Random random = new Random();
    final private Weapon fists = new Weapon("Fists", 0, 1.3);
    final private Armor shirt = new Armor("Shirt", 0, 0);

    public void levelUp() {
        level++;
        health = (int) (health * levelUpHealthModifier);
        baseDamage = (int) (baseDamage * levelUpDamageModifier);
    }

    public void levelDown() {
        level--;
        health = (int) (health / levelUpHealthModifier);
        baseDamage = (int) (baseDamage / levelUpDamageModifier);
    }

    public void attack(Champion enemy) {
        System.out.println();
        boolean criticalHit = false;
        boolean criticalMiss = false;
        int critRoll = Dice.roll20();
        if (critRoll >= toCrit) {
            criticalHit = true;
        } else if (critRoll == 1) {
            criticalMiss = true;
        }
        //Rollar mellan 1 och baseDamage, lägger till weapon damage --> gångras med karaktärens och vapnets crit modifier vid crit
        int attackDamage = (int) ((random.nextInt(1, baseDamage) + weapon.getWeaponDamage()) * (criticalHit ? weapon.getCritModifier() * critBonusModifier : 1));
        int enemyArmor = enemy.getArmor().getArmorValue() + enemy.getBaseArmor();
        int totalAttackDamage;
        int deflected;
        if (!criticalMiss) {
            if (enemyArmor > attackDamage) {
                //Ser till så att man inte kan deflecta mer än vad man har i armor
                deflected = attackDamage;
                totalAttackDamage = 0;
            } else {
                totalAttackDamage = attackDamage - enemyArmor;
                deflected = enemyArmor;
            }
            enemy.setHealth(enemy.getHealth() - totalAttackDamage);
            System.out.println(criticalHit ?
                    name + " CRITICALLY HITS " + enemy.getName() + " for " + attackDamage + "!"
                    :
                    name + " attacked " + enemy.getName() + " for " + attackDamage + "!");
            if (deflected > 0) {
                System.out.println(enemy.getName() + " deflected " + deflected + " points of damage!");
            }
            System.out.println(enemy.getName() + " took " + totalAttackDamage + " damage!");
            if (enemy.getHealth() < 1) {
                enemy.playerKilled();
                System.out.println(enemy.name + " died...");
                System.out.println("The winner is " + name + "!");
            } else {
                System.out.println(enemy.getName() + " has " + enemy.getHealth() + " health left...");
            }
        } else {
            System.out.println(name + " critically missed!");
        }
    }

    public void pickUpWeapon(Weapon weapon) {
        if (weapon.getWeaponDamage() > this.weapon.getWeaponDamage()) {
            this.weapon = weapon;
            System.out.println("Weapon: " + weapon.getName() + " was picked up by " + name + "!");
        } else {
            System.out.println(name + " could not find a better weapon...");
        }
    }

    public void pickUpArmor(Armor armor) {
        if (armor.getArmorValue() > this.armor.getArmorValue()) {
            this.armor = armor;
            System.out.println("Armor: " + armor.getName() + " was picked up by " + name + "!");
            setHealth(getHealth() + this.armor.getHealthBonus());
        } else {
            System.out.println(name + " could not find a better armor...");
        }
    }

    public void dropArmor() {
        this.setHealth(getHealth() - armor.getHealthBonus());
        setArmor(shirt);
    }

    public void dropWeapon() {
        setWeapon(fists);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void playerKilled() {
        isAlive = false;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public ArrayList<SpecialPower> getSpecialPowers() {
        return specialPowers;
    }

    public int getActivePowerIndex() {
        return activePowerIndex;
    }

    public void setActivePowerIndex(int activePowerIndex) {
        this.activePowerIndex = activePowerIndex;
    }

    public boolean isSpecialPowerActive() {
        return specialPowerActive;
    }

    public void setSpecialPowerActive(boolean specialPowerActive) {
        this.specialPowerActive = specialPowerActive;
    }


    @Override
    public String toString() {
        return "Champion: " + name +
                "Health: " + health +
                "Level: " + level;
    }
}
