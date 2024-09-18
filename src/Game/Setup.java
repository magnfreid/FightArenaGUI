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
                new Armor("Tactical Vest", 5, 0),
                new Armor("Heavy Combat Armor", 25, 20),
                new Armor("Reinforced Chestplate", 32, 25),
                new Armor("Energy Shield", 8, 15),
                new Armor("Power Armor", 46, 10),
                new Armor("Cyber Leather Jacket", 18, 30),
                new Armor("Ballistic Bodysuit", 41, 40),
                new Armor("Light Combat Armor", 9, 10),
                new Armor("Military Helmet", 6, 5),
                new Armor("Adaptive Cloak", 25, 50)
        ));
    }

    static {
        // Initialize the list of weapons
        weapons.addAll(Arrays.asList(
                new Weapon("Plasma Rifle", 60, 1.30),
                new Weapon("Cleaver Axe", 20, 1.55),
                new Weapon("Shock Baton", 14, 1.15),
                new Weapon("Shiv", 10, 5.00),
                new Weapon("Laser Pistol", 18, 1.15),
                new Weapon("Sword", 15, 1.10),
                new Weapon("Crossbow", 12, 1.25),
                new Weapon("EMP Blaster", 45, 1.30),
                new Weapon("Latrine Shovel", 5, 1.05),
                new Weapon("Shotgun", 42, 1.18),
                new Weapon("Chainsaw", 37, 1.75),
                new Weapon("Spear", 20, 1.22),
                new Weapon("Hammer", 25, 1.40),
                new Weapon("Explosive Charge", 50, 1.05),
                new Weapon("Rocket Launcher", 75, 1.00),
                new Weapon("Electro Whip", 10, 1.35),
                new Weapon("Boomerang Blade", 35, 1.25),
                new Weapon("Power Fist", 44, 1.20),
                new Weapon("Golf club", 8, 1.30),
                new Weapon("Knuckles", 5, 1.10)

        ));
    }

    //TODO Add consumables

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
