package pets_amok;

public class RobotAnimals extends VirtualPet {
   int rust = 200;

    public RobotAnimals(String name, String desc, int rust) {
        super(name, desc);
        this.rust = rust;
    }

    public void oiling() {
        rust -= 80;
    }



}
