package pets_amok;

public class OrganicCats extends Cats implements OrganicPets {
    protected int hunger;
    protected int thirst;

    public OrganicCats(String name, String desc) {
        super(name, desc);
        hunger = 50;
        thirst = 50;	}
    @Override
    public void feed() {
        hunger -= 20;
        happiness += 10;
    }

    @Override
    public void water() {
        thirst -= 20;
        happiness += 10;
    }

    @Override
    public void play() {
        happiness += 20;
        hunger += 10;
        thirst += 10;
    }

    @Override
    public int tick() {
        hunger += (5 + generateRandom());
        thirst += (5 + generateRandom());
        happiness -= (5 + generateRandom());
        return (1 + generateRandom());
    }

    @Override
    public int getHunger() {
        return hunger;
    }

    @Override
    public int getThirst() {
        return thirst;
    }


}