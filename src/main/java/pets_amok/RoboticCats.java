package pets_amok;

public class RoboticCats extends Cats implements RoboticPets {

    int oilLevel;

    public RoboticCats(String name, String desc) {
        super(name, desc);
        oilLevel = 50;
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
    public void increaseHappines() {
        happiness += 10;
        health += 10;
    }
}


