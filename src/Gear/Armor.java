package Gear;

public class Armor extends Item {
    final private int armorValue;
    final private int healthBonus;

    public Armor(String name, int armorValue, int healthBonus) {
        super(name);
        this.armorValue = armorValue;
        this.healthBonus = healthBonus;
    }

    public int getArmorValue() {
        return armorValue;
    }

    public int getHealthBonus() {
        return healthBonus;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + name + '\'' +
                ", healthBonus=" + healthBonus +
                ", armorValue=" + armorValue +
                '}';
    }
}