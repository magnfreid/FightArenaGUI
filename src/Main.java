import Fighter.Fighter;
import Game.Arena;

public class Main {
    public static void main(String[] args) {
        Arena arena = new Arena();
        Fighter chance  = new Fighter("Chance");
        Fighter darkus = new Fighter("Darkus");
        try {
            arena.fight(chance, darkus);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}