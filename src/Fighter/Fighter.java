package Fighter;

import Gear.Armor;
import Gear.Weapon;

import java.util.Random;

public abstract class Fighter implements Character {
    final protected String name;
    protected int health, level, baseDamage, baseArmor, toCrit;
    protected double critBonusModifier;
    protected Weapon weapon;
    protected Armor armor;
    final private Weapon fist = new Weapon("Fists", 0, 1.3);
    final private Armor shirt = new Armor("Shirt", 0, 0);
    protected boolean isAlive = true;

    public Fighter(String name) {
        this.name = name;
        this.health = 100;
        this.level = 1;
        this.baseDamage = 10;
        this.baseArmor = 0;
        this.weapon = fist;
        this.armor = shirt;
        this.critBonusModifier = 1;
        this.toCrit = 20;
    }

    Random random = new Random();

    public void levelUp() {
        level++;
        double healthModifier = 1.05;
        double damageModifier = 1.15;
        health = (int) (health * healthModifier);
        baseDamage = (int) (baseDamage * damageModifier);
    }

    public void attack(Fighter enemy) {
        System.out.println();
        boolean criticalHit = false;
        boolean criticalMiss = false;
        //TODO tror critten rollar fel
        int critRoll = random.nextInt(1, 21);
        System.out.println("critRoll = " + critRoll);
        System.out.println();
        if (critRoll >= toCrit) {
            criticalHit = true;
        } else if (critRoll == 1) {
            criticalMiss = true;
        }
        int attackDamage = (int) ((random.nextInt(1, baseDamage) + weapon.getWeaponDamage()) * (criticalHit ? weapon.getCritModifier() * critBonusModifier : 1));
        int enemyArmor = enemy.getArmor().getArmorValue() + enemy.getBaseArmor();
        int totalAttackDamage;
        int deflected;
        if (!criticalMiss) {
            if (enemyArmor > attackDamage) {
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
                enemy.playerDeath();
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

    void dropArmor() {
        this.setHealth(getHealth() - armor.getHealthBonus());
        setArmor(shirt);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void playerDeath() {
        isAlive = false;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", level=" + level +
                ", baseDamage=" + baseDamage +
                ", baseArmor=" + baseArmor +
                ", toCrit=" + toCrit +
                ", critBonusModifier=" + critBonusModifier +
                ", weapon=" + weapon +
                ", armor=" + armor +
                ", fist=" + fist +
                ", shirt=" + shirt +
                ", isAlive=" + isAlive +
                ", random=" + random +
                '}';
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setToCrit(int toCrit) {
        this.toCrit = toCrit;
    }

    public void setBaseArmor(int baseArmor) {
        this.baseArmor = baseArmor;
    }
}
