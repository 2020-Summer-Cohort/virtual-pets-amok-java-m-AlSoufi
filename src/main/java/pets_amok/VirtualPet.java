package pets_amok;

public class VirtualPet {

    protected String name;
    protected String desc;
    protected  int health = 100;
    protected int happiness = 150;

    public VirtualPet(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.health = health = 100;
        this.happiness = happiness = 150;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHealth() {
        return health;
    }

    public void walkingDogs() {
    }
}
