package Gear;

public class Weapon extends Item  {
    final private int weaponDamage;
    final private double critModifier;

    public Weapon(String name, int weaponDamage, double critModifier) {
        super(name);
        this.weaponDamage = weaponDamage;
        this.critModifier = critModifier;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public double getCritModifier() {
        return critModifier;
    }


    @Override
    public String toString() {
        return "Weapon{" +
                "weaponDamage=" + weaponDamage +
                ", critModifier=" + critModifier +
                ", name='" + name + '\'' +
                '}';
    }
}
