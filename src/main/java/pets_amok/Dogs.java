package pets_amok;

public abstract class Dogs extends VirtualPet {

    public Dogs(String name, String desc) {
        super(name, desc);
    }

    public abstract void walk();


}
