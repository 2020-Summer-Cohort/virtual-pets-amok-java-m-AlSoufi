package pets_amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
    private int litterBox = 50;

    private Map<String, VirtualPet> petMap = new HashMap<String, VirtualPet>();

    public int getLitterBox() {
        return litterBox;
    }

    public void cleanLitterBox() {
        litterBox = 0;
    }

    public void oilRoboticPets() {
        for (VirtualPet pet : pets()) {
            if (pet instanceof RoboticPets) {
                ((RoboticPets) pet).oilPet();
                ((RoboticPets) pet).increaseHappines();
            }
        }
    }

    public void cleanOrganicDogCages() {
        for (VirtualPet pet : pets()) {
            if (pet instanceof OrganicDogs) {
                ((OrganicDogs) pet).cleanCage();
            }
        }
    }

    public void walkAllDogs() {
        for (VirtualPet pet : pets()) {
            if (pet instanceof Dogs) {
                ((Dogs) pet).walk();
            }
        }

    }

    public void adoptPet(RoboticPets pet) {
        petMap.put(pet.getName(), (VirtualPet) pet);
    }

    public void adoptPet(OrganicPets pet) {
        petMap.put(pet.getName(), (VirtualPet) pet);
    }

    public void feedAllOrganicPets() {
        for (VirtualPet pet : pets()) {
            if (pet instanceof OrganicPets) {
                ((OrganicPets) pet).feed();
            }
        }
        litterBox += 10;
    }

    public void waterAllOrganicPets() {
        for (VirtualPet pet : pets()) {
            if (pet instanceof OrganicPets) {
                ((OrganicPets) pet).water();
            }
        }
        litterBox += 5;
    }


    void tickAllPets() {
        for (VirtualPet pet : pets()) {
            if (pet instanceof OrganicCats) {
                litterBox += ((OrganicCats) pet).tick();
            }
            if (!(pet instanceof OrganicCats))
                if (pet instanceof OrganicDogs) {
                    ((OrganicDogs) pet).tick();
                }
            if (pet instanceof RoboticPets) {
                ((RoboticPets) pet).tick();
            }
        }
    }


    public Collection<VirtualPet> pets() {
        return petMap.values();
    }


    public VirtualPet getPet(String name) {
        return petMap.get(name);
    }


    public void playWithSinglePet(VirtualPet player) {
        player.play();
    }


    public void adoptPet(VirtualPet pet) {
        petMap.remove(pet.getName());
    }
}