package Fighter;

import Items.Armor;
import Items.Consumable;
import Items.Weapon;

import javax.sql.ConnectionPoolDataSource;
import java.util.Random;

public class Fighter {
    private final String name;
    private int health, level, baseDamage;
    private Weapon weapon;
    private Armor armor;
    private Consumable consumable;

    public Fighter(String name) {
        this.name = name;
        this.health = 100;
        this.level = 1;
        this.baseDamage = 12;
        this.weapon = new Weapon("Fists", 0, 1.3);
        this.armor = new Armor("Shirt", 0, 0);
        this.consumable = new Consumable("Empty pockets", 0, 0);
    }

    Random random = new Random();

    public void levelUp() {
        level++;
        double modifier = 1.15;
        health = (int) (health * modifier);
        baseDamage = (int) (baseDamage * modifier);
    }

    public void attack(Fighter enemy) {
        boolean criticalHit = false;
        int critRoll = random.nextInt(1, 21);
        if (critRoll == 20) {
            criticalHit = true;
        }
        //Rollar 1-baseDamage, lägger till weapon damage och gångrar med crit modifier vid crit
        int attackDamage = (int) ((random.nextInt(1, this.baseDamage) + this.weapon.damage()) * (criticalHit ? this.weapon.crit() : 1));
        int enemyArmor = enemy.getArmor().armorValue();
        int totalAttackDamage = attackDamage - enemyArmor;
        if (totalAttackDamage < 0) {
            totalAttackDamage = 0;
        }
        enemy.setHealth(enemy.getHealth() - totalAttackDamage);
        System.out.println(criticalHit ?
                this.name + " CRITICALLY HITS " + enemy.getName() + " for " + attackDamage + "!"
                :
                this.name + " attacked " + enemy.getName() + " for " + attackDamage + "!");
        //TODO nåt är fel här, får ibland minus-damage
        if (enemyArmor > 0) {
            int deflected = enemyArmor;
            if (deflected > totalAttackDamage) {
                deflected = totalAttackDamage;
            }
            System.out.println(enemy.getName() + " deflected " + deflected + " points of damage!");
        }
        System.out.println(enemy.getName() + " took " + (attackDamage - enemy.getArmor().armorValue()) + " damage!");
        System.out.println(enemy.getName() +" has " + enemy.getHealth() +" health left...");
        System.out.println();
    }

    public void pickUpWeapon(Weapon weapon) {
        if (weapon.damage() > this.weapon.damage()) {
            this.weapon = weapon;
            System.out.println(weapon.name() + " was picked up by " + this.name + "!");
        }
    }



    public void pickUpArmor(Armor armor) {
        if (armor.armorValue() > this.armor.armorValue()) {
            this.armor = armor;
            System.out.println(armor.name() + " was picked up by " + this.name + "!");
        }
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


    public Armor getArmor() {
        return armor;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
