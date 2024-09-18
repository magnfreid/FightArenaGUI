package Game;

import Items.Consumable;
import Items.Armor;
import Items.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

public class Setup {
    private static final ArrayList<Consumable> consumables = new ArrayList<>();
    private static final ArrayList<Weapon> weapons = new ArrayList<>();
    private static final ArrayList<Armor> armors = new ArrayList<>();

    static {
        // Initialize the list of armors
        armors.addAll(Arrays.asList(
                new Armor("Bubble Wrap Vest", 10, 20),
                new Armor("Cardboard Knight Armor", 15, 10),
                new Armor("Pillow Fort Chestplate", 20, 25),
                new Armor("Wi-Fi Router Shield", 8, 15),
                new Armor("Tinfoil Hat", 5, 0),
                new Armor("Leather Jacket of Coolness", 18, 30),
                new Armor("Yoga Mat Body Suit", 12, 40),
                new Armor("Inflatable Pool Armor", 9, 10),
                new Armor("Traffic Cone Helm", 6, 5),
                new Armor("Ultimate Hoodie of Comfort", 25, 50)
        ));
    }

    static {
        // Initialize the list of weapons
        weapons.addAll(Arrays.asList(
                new Weapon("Tactical Nerf Blaster", 25, 1.05),
                new Weapon("Spatula of Doom", 10, 1.20),
                new Weapon("Taser X9000", 30, 1.15),
                new Weapon("Golf Club of Destruction", 35, 1.25),
                new Weapon("Laser Pointer MkII", 5, 1.50),
                new Weapon("Super Soaker 3000", 15, 1.10),
                new Weapon("Electric Toothbrush", 8, 1.35),
                new Weapon("Smartphone of Mass Distraction", 10, 1.30),
                new Weapon("Laptop Shield", 5, 1.05),
                new Weapon("Microwave Ray Gun", 40, 1.18),
                new Weapon("Chainsaw 5000", 60, 1.10),
                new Weapon("BBQ Fork of Fury", 20, 1.22),
                new Weapon("Slipper of Ultimate Justice", 15, 1.40),
                new Weapon("Exploding Soda Can", 25, 1.28),
                new Weapon("RC Helicopter with Missiles", 50, 1.12),
                new Weapon("Electric Fly Swatter", 10, 1.35),
                new Weapon("Boomerang of Betrayal", 35, 1.25),
                new Weapon("Selfie Stick Saber", 20, 1.20),
                new Weapon("Drone Delivery Strike", 55, 1.30),
                new Weapon("Rubber Chicken of Chaos", 10, 1.50)
        ));
    }

    public static ArrayList<Consumable> loadConsumables() {
        return consumables;
    }

    public static ArrayList<Weapon> loadWeapons() {
        return weapons;
    }

    public static ArrayList<Armor> loadArmors() {
        return armors;
    }
}
