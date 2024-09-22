package Champion.Classes;

import Champion.Champion;
import Champion.SpecialPower;
import java.util.ArrayList;

public class Rogue extends Champion {
    public Rogue(String name) {
        super(name);
        this.baseDamage = 20;
        this.health = 80;
        this.critBonusModifier = 1.5;
        this.toCrit = 18;
        this.specialPowers = new ArrayList<>();
        this.specialPowers.add(new Backstab());
        this.specialPowers.add(new Dodge());
        this.championClass = "Rogue";
    }

    private class Backstab implements SpecialPower {

        @Override
        public void activatePower() {
            System.out.println(name + " goes for the eyes!");
            toCrit -= 16;
        }

        @Override
        public void deactivatePower() {
            toCrit += 16;
        }
    }

    private class Dodge implements SpecialPower {

        @Override
        public void activatePower() {
            System.out.println(name + " dodges!");
            baseArmor += 50;
        }

        @Override
        public void deactivatePower() {
            baseArmor -= 50;
        }
    }

}
