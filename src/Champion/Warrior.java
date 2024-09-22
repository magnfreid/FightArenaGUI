package Champion;

import java.util.ArrayList;

public class Warrior extends Champion {
    public Warrior(String name) {
        super(name);
        this.championClass = "Warrior";
        this.baseArmor = 10;
        this.health = 150;
        this.specialPowers = new ArrayList<>();
        specialPowers.add(new Rampage());
        specialPowers.add(new IgnorePain());
    }

private class Rampage implements SpecialPower {

    @Override
    public void activatePower() {
        System.out.println(name + " is on a rampage!");
        for (int i = 0; i<10; i++) {
           levelUp();
        }
    }

    @Override
    public void deactivatePower() {
        for (int i = 0; i<10; i++) {
            levelDown();
        }
    }
}private class IgnorePain implements SpecialPower {

    @Override
    public void activatePower() {
        System.out.println(name + " ignores all pain!");
health += 50;
    }

    @Override
    public void deactivatePower() {
    }
}



}
