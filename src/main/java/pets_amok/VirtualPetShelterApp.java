package pets_amok;

import java.util.Scanner;

public class VirtualPetShelterApp {

    public static void main(String[] args) {

        VirtualPetShelter shelter = new VirtualPetShelter();
        Scanner input = new Scanner(System.in);

        OrganicPets steve = new OrganicDogs("Max", "German Shepherd");
        shelter.adoptPet(steve);
        RoboticPets paul = new RoboticDogs("Rex", "A robotic dog");
        shelter.adoptPet(paul);
        OrganicPets jess = new OrganicCats("Jerry", "Tabby");
        shelter.adoptPet(jess);
        RoboticPets oly = new RoboticCats("Garfield", "A robotic cat");
        shelter.adoptPet(oly);

        boolean quit = false;

        do {
            if (shelter.getLitterBox() >= 100) {
                System.out.println("Shelter update: The litterbox is full and it's negatively affecting the health of all organic cats in the shelter.");
                for (VirtualPet pet : shelter.pets()) {
                    if (pet instanceof OrganicCats) {
                        ((OrganicCats) pet).decreaseHealth();
                    }
                }
            }
            for (VirtualPet pet : shelter.pets()) {
                if (pet instanceof OrganicDogs) {

                    if (((OrganicDogs) pet).getCageMess() >= 100) {
                        System.out.println("Shelter update: The organic dog " + pet.getName()
                                + "'s cage needs cleaning and it's currently negatively affecting their health.");
                        ((OrganicDogs) pet).decreaseHealth();
                    }
                }
            }
            for (VirtualPet pet : shelter.pets()) {
                if (pet instanceof RoboticPets) {

                    if (((RoboticPets) pet).getOilLevel() <= 10) {
                        System.out.println("Shelter update: The robotic pet " + pet.getName()
                                + "'s rust level is high due to lack of oiling and it's currently negatively affecting their health.");
                        pet.decreaseHealth();
                    }
                }
            }
            System.out.println("\nThank you for volunteering at The Neighborhood Virtual Pet Shelter!");
            System.out.println("\nThis is the status of our pets currently: ");
            System.out.println("\nName\t              |Hapiness\t   |Health\t |Hunger\t|Thirst\t|OilLvl\t|CageDirtiness");
            System.out.println("----------------------|------------|---------|----------|-------|-------|---------------");

            for (VirtualPet currentPet : shelter.pets()) {
                System.out.print(currentPet.getName() + "\t                  |" + ((VirtualPet) currentPet).getHappiness() + "    \t   |"
                        + ((VirtualPet) currentPet).getHealth() + " \t     |");
                if (currentPet instanceof OrganicPets) { System.out.print(((OrganicPets) currentPet).getHunger() + " \t            |"
                            + ((OrganicPets) currentPet).getThirst() + "  \t                 |N/A\t|");
                } else if (currentPet instanceof RoboticPets) {
                    System.out.print("N/A\t    |N/A\t|" + ((RoboticPets) currentPet).getOilLevel() + " \t|");
                }
                if (currentPet instanceof OrganicDogs) {
                    System.out.print("" + ((OrganicDogs) currentPet).getCageMess() + "\t  |");
                } else {
                    System.out.print("N/A\t        |");
                }
                System.out.print("\n");

            }

            System.out.println("The litterbox messiness level is: " + shelter.getLitterBox());
            System.out.println("\nWhat would you like to do next?");
            System.out.println(
                    "\n1. Feed the organic pets. \n2. Water the organic pets. \n3. Play with a pet. \n4. Adopt a pet. \n5. Admit a pet. \n6. Clean Cages \n7. Clean Litterbox \n8. Walk Dogs \n9. Maintain all RoboPets by oiling them. \n10. Do nothing. \n11. Quit.");
            String userImput = input.nextLine();

            switch (userImput) {
                case "1":
                    shelter.feedAllOrganicPets();
                    System.out.println("You fed all the organic pets!");
                    break;
                case "2":
                    shelter.waterAllOrganicPets();
                    System.out.println("You watered all the organic pets!");
                    break;
                case "3": // play
                    System.out.println("Ok, so you'd like to play with a pet. Please choose one:\n");
                    listPets(shelter);
                    System.out.println("\nWhich pet would you like to play with?");
                    String petName = input.nextLine();
                    shelter.playWithSinglePet(shelter.getPet(petName));
                    System.out.println("OK, play with " + shelter.getPet(petName).getName() + ". ");
                    break;
                case "4": // adopt
                    System.out.println("Please choose the pet you would like to adopt?\n");
                    listPets(shelter);
                    System.out.println("\nWhich pet would you like to adopt");
                    String nameToAdopt = input.nextLine();
                    VirtualPet pet = shelter.getPet(nameToAdopt);
                    shelter.adoptPet(pet);
                    System.out.println("You adopted " + pet.getName() + ". Please take good care of him/her!");
                    break;
                case "5":// intake
                    System.out.println("Ok you have a pet for us! Is it organic or robotic?");
                    String response2 = input.next();
                    if (response2.equalsIgnoreCase("organic")) {
                        System.out.println("Great! is your organic pet a cat or a dog?");
                        String response3 = input.next();
                        input.nextLine();
                        if (response3.equalsIgnoreCase("dog")) {
                            System.out.println("Great! What is the dog's name?");
                            String name = input.nextLine();
                            System.out.println("Great! What is a short description of the dog?");
                            String description = input.nextLine();
                            OrganicPets x = new OrganicDogs(name, description);
                            shelter.adoptPet(x);
                            System.out.println("Thanks! We'll take good care of " + x.getName()+".");
                        } else if (response3.equalsIgnoreCase("cat")) {
                            System.out.println("Great! What is the cat's name?");
                            String name = input.nextLine();

                            System.out.println("Great! What is a short description of the cat?");
                            String description = input.nextLine();
                            OrganicPets y = new OrganicCats(name, description);
                            shelter.adoptPet(y);
                            System.out.println("Thanks! We'll take good care of " + y.getName()+".");
                        }

                    } else if (response2.equalsIgnoreCase("robotic")) {
                        System.out.println("Great! is your robotic pet a cat or a dog?");
                        String response3 = input.next();
                        input.nextLine();

                        if (response3.equalsIgnoreCase("dog")) {
                            System.out.println("Great! What is the dog's name?");
                            String name = input.nextLine();
                            System.out.println("Great! What is a short description of the dog?");
                            String description = input.nextLine();
                            RoboticPets r = new RoboticDogs(name, description);
                            shelter.adoptPet(r);
                            System.out.println("Thanks! We'll take good care of " + r.getName()+".");

                        } else if (response3.equalsIgnoreCase("cat")) {
                            System.out.println("Great! What is the cat's name?");
                            String name = input.nextLine();
                            System.out.println("Great! What is a short description of the cat?");
                            String description = input.nextLine();
                            RoboticPets w = new RoboticCats(name, description);
                            shelter.adoptPet(w);
                            System.out.println("Thanks! We'll take good care of " + w.getName()+".");
                        }
                    }
                    break;
                case "6":
                    shelter.cleanOrganicDogCages();
                    System.out.println("You just cleaned all the organic dog cages!");
                    break;
                case "7":
                    shelter.cleanLitterBox();
                    System.out.println("You cleaned the litterbox!");
                    break;
                case "8":
                    shelter.walkAllDogs();
                    System.out.println("You walked all the dogs!");
                    break;
                case "9":
                    shelter.oilRoboticPets();
                    System.out.println("You maintained all robotic pets!");
                    break;
                case "10":
                    // tick
                    break;
                case "11":
                    System.out.println("Have a great day! Thanks for volunteering!");
                    System.exit(0);
                default:
                    System.out.println("You have chosen an invalid option. Try again.");
                    break;
            }
            shelter.tickAllPets();

        } while (!quit);
        input.close();
    }

    private static void listPets(VirtualPetShelter shelter) {
        for (VirtualPet currentPet : shelter.pets()) {
            System.out.println("" + currentPet);
        }
    }

    public static void Systemoutprintln(String message) {
        System.out.println(message);
    }
}