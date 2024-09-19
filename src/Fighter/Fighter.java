package Fighter;

import Items.Armor;
import Items.Consumable;
import Items.Weapon;
import java.util.Random;

public class Fighter {
    private final String name;
    private int health, level, baseDamage;
    private Weapon weapon;
    private Armor armor;
    private Consumable consumable;
    final private Weapon fist = new Weapon("Fists", 0, 1.3);
    final private Armor shirt = new Armor("Shirt", 0, 0);
final private Consumable emptyPockets = new Consumable("Empty pockets", 0, 0);

    boolean isAlive = true;

    public Fighter(String name) {
        this.name = name;
        this.health = 100;
        this.level = 1;
        this.baseDamage = 12;
        this.weapon = fist;
        this.armor = shirt;
        this.consumable = emptyPockets;
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
        int critRoll = random.nextInt(1, 21);
        if (critRoll == 20) {
            criticalHit = true;
        }
        //Rollar 1-baseDamage, lägger till weapon damage och gångrar med crit modifier vid crit
        int attackDamage = (int) ((random.nextInt(1, baseDamage) + weapon.damage()) * (criticalHit ? weapon.crit() : 1));
        int enemyArmor = enemy.getArmor().armorValue();
        int totalAttackDamage;
        int deflected;
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
        if (enemy.getHealth() <1) {
            enemy.playerDeath();
            System.out.println(enemy.name + " died...");
            System.out.println("The winner is " + name +"!");
        }
        else  {
            System.out.println(enemy.getName() + " has " + enemy.getHealth() + " health left...");
        }
    }

    public void pickUpWeapon(Weapon weapon) {
        if (weapon.damage() > this.weapon.damage()) {
            this.weapon = weapon;
            System.out.println("Weapon: " + weapon.name() + " was picked up by " + name + "!");
        }
        else {
            System.out.println(name + " could not find a better weapon...");
        }
    }


    public void pickUpArmor(Armor armor) {
        if (armor.armorValue() > this.armor.armorValue()) {
            this.armor = armor;
            System.out.println("Armor: " + armor.name() + " was picked up by " + name + "!");
           setHealth(getHealth() + this.armor.healthBonus());
        }
        else {
            System.out.println(name + " could not find a better armor...");
        }
    }

    void dropArmor() {
        this.setHealth(getHealth() - armor.healthBonus());
        setArmor(shirt);
    }

    public void pickUpConsumable(Consumable consumable) {
        this.consumable = consumable;
    }

    public void useConsumable() {

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
}
