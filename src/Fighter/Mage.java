package Fighter;

public class Mage extends Fighter{
    public Mage(String name) {
        super(name);
        this.health = 80;
    }
//TODO dessa funkar inte!!!!!!
    @Override
    public void useSpecialPower() {
        System.out.println(name + " charges up!");
        this.baseDamage = 75;
        toggleSpecialPower();
    }

}
