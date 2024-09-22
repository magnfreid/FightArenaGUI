import Champion.Classes.Mage;
import Champion.Classes.Rogue;
import Game.Arena;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Arena arena = new Arena();
        Mage mage = new Mage("Darkus");
        Rogue rogue = new Rogue("Havarian");
        arena.fight(mage, rogue);

    }
}