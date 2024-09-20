package Fighter;

public class Rogue extends Fighter {
    public Rogue(String name) {
        super(name);
        this.baseDamage = 20;
        this.health = 80;
        this.critBonusModifier = 1.5;
        this.toCrit = 18;
    }

    @Override
    public void useSpecialPower() {
        System.out.println(name + " goes for the eyes!");
        this.toCrit = 2;
        toggleSpecialPower();
    }

}
