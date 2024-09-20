package Fighter;

public class Mage extends Fighter{
    public Mage(String name) {
        super(name);
        this.health = 80;
    }

    @Override
    public void useSpecialPower() {
        System.out.println(name + " charges up!");
        baseDamage = 100;
    }

    @Override
    public void endSpecialPower() {
        baseDamage = 10;
    }

}
