package Fighter;

public class Warrior extends Fighter{
    public Warrior(String name) {
        super(name);
        this.baseArmor = 10;
        this.health = 150;
    }


    @Override
    public void useSpecialPower() {
        System.out.println(name + " is on a rampage!");
        baseArmor = 100;
        toggleSpecialPower();
    }


}
