package Game;

import java.util.Random;

public class Dice {
    static Random random = new Random();


    public  static int roll20() {
        return random.nextInt(1,21);
    }

}
