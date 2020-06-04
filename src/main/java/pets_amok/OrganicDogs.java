package pets_amok;

public class OrganicDogs extends Dogs implements OrganicPets {

    protected int cageMess;
    protected int hunger;
    protected int thirst;

    public OrganicDogs(String name, String desc) {
        super(name, desc);
        cageMess = 50;
        hunger = 50;
        thirst = 50;
    }

    public void feed() {
        hunger -= 20;
        happiness += 10;
        cageMess += 10;
    }

    public void water() {
        thirst -= 20;
        happiness += 10;
        cageMess += 10;
    }

    @Override
    public void walk() {
        cageMess -= 20;
        happiness += 20;
        health += 10;
        hunger += 5;
        thirst += 5;
    }

    @Override
    public void play() {
        happiness += 20;
        hunger += 10;
        thirst += 10;
        health += 10;
    }

    @Override
    public int tick() {
        hunger += (5 + generateRandom());
        thirst += (5 + generateRandom());
        happiness -= (5 + generateRandom());
        cageMess += (5 + generateRandom());
        return 0;
    }

    @Override
    public int getHunger() {
        return hunger;
    }

    public int getCageMess() {
        return cageMess;
    }

    public void cleanCage() {
        cageMess = 0;
        happiness += 10;
        health += 10;
    }

    @Override
    public int getThirst() {
        return thirst;
    }
}