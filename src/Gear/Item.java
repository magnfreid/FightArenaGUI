package Gear;

public abstract class Item {
   final protected String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
