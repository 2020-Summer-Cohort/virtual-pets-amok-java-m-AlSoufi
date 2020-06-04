package pets_amok;

import java.util.Random;

public abstract class VirtualPet {

    protected Random generator = new Random();

    protected String name;
    protected String desc;
    protected int health;
    protected int happiness;

    public VirtualPet(String name, String desc) {
        this.name = name;
        this.desc = desc;
        health = 50;
        happiness = 50;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getHappiness() {
        return happiness;
    }

    public abstract void play();

    public int generateRandom() {
        return generator.nextInt(10);
    }

    @Override
    public String toString() {
        return ("[" + name + "] " + desc);
    }

    public void decreaseHealth() {
        health -= 10;
    }
}