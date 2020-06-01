package pets_amok;

import java.util.HashMap;
import java.util.Map;

abstract class VirtualPetShelter {

    Map<String, VirtualPet> dogMap = new HashMap<String, VirtualPet>();

    public void setDogMap() {
        String name;
        String desc;
    }
    public void walkAllDogs() {
        for (VirtualPet petToWalk : petMap.values()) {
            petToWalk.walkingDogs();
        }
}
}