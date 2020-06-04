package pets_amok;

public class RoboticDogs extends Dogs implements RoboticPets {
    int oilLevel;

    public RoboticDogs(String name, String desc) {
        super(name, desc);
        oilLevel = 50;
    }

    @Override
    public void walk() {
        happiness += 20;
        health += 10;
        oilLevel -= 5;
    }

    @Override
    public void play() {
        happiness += 20;
        oilLevel -= 5;
    }

    @Override
    public void tick() {
        happiness -= (5 + generateRandom());
        oilLevel -= (5 + generateRandom());
    }

    @Override
    public void oilPet() {
        oilLevel += 20;
    }

    @Override
    public int getOilLevel() {
        return oilLevel;
    }

    @Override
    public void becomeHappy() {
        happiness += 10;
        health += 10;
    }

}