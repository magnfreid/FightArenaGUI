import Fighter.Fighter;
import Game.Arena;

public class Main {
    public static void main(String[] args) {
        Arena arena = new Arena();
        Fighter magnus = new Fighter("Magnus");
        Fighter darkus = new Fighter("Darkus");
        try {
            arena.fight(magnus, darkus);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}