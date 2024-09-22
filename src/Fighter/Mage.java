package Fighter;

import java.util.ArrayList;

public class Mage extends Fighter {
    public Mage(String name) {
        super(name);
        this.health = 80;
        this.specialPowers = new ArrayList<>();
        this.specialPowers.add(new Fireball());
        this.specialPowers.add(new MagicShield());
    }


    private class Fireball implements SpecialPower {

        public void activatePower() {
            System.out.println(name + " throws a fireball! BURN!!!");
            baseDamage += 100;
        }


        public void deactivatePower() {
            baseDamage -= 100;
        }
    }

    private class MagicShield implements SpecialPower {

        @Override
        public void activatePower() {
            System.out.println(name + " conjures a magical shield!");
            baseArmor += 1000;
        }


        public void deactivatePower() {
            baseArmor -= 1000;
        }
    }
}
