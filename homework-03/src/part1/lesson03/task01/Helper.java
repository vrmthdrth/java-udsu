package part1.lesson03.task01;

import part1.lesson03.task01.comparators.PetNameComparator;
import part1.lesson03.task01.comparators.PetOwnerComparator;
import part1.lesson03.task01.comparators.PetWeightComparator;
import part1.lesson03.task01.entities.Person;
import part1.lesson03.task01.entities.Pet;
import part1.lesson03.task01.petCardIndex.PetCardIndex;

import java.util.Scanner;
import java.util.UUID;

public class Helper {

    public static void mainProcedure(){
        PetCardIndex petCardIndex = initializePetCardIndexFromConsole();
        displayPetCardIndexInConsole(petCardIndex);
        boolean keepEditing = true;
        while(keepEditing){
            Scanner input = new Scanner(System.in);
            System.out.println("what you want to do\n1 - add pet\n2 - find by Name\n3.1 - change name by Id\n3.2 - change owner by Id\n3.3 - change weight by Id\n4.1 sort by pet name and display\n4.2 - sort by owner name and display\n4.3 - sort by pet weight and display\n5 - display\n6 - skip)");
            UUID id;
            switch(input.next()){
                case "1":
                    petCardIndex.add(initializePetFromConsole());
                    break;
                case "2":
                    System.out.println("Enter name to find pet");
                    System.out.println(petCardIndex.getPetByName(input.next()).toString());;
                    break;
                case "3.1":
                    System.out.println("Enter id");
                    id = UUID.fromString(input.next());
                    System.out.println("Enter new name");
                    petCardIndex.setPetNameByUUID(id, input.next());
                    break;
                case "3.2":
                    System.out.println("Enter id");
                    id = UUID.fromString(input.next());
                    System.out.println("Enter new owner info");
                    petCardIndex.setPetOwnerByUUID(id, initializeOwnerFromConsole());
                    break;
                case "3.3":
                    System.out.println("Enter id");
                    id = UUID.fromString(input.next());
                    System.out.println("Enter new weight");
                    petCardIndex.setPetWeightByUUID(id, input.nextInt());
                    break;
                case "4.1":
                    petCardIndex.sort(new PetNameComparator());
                    displayPetCardIndexInConsole(petCardIndex);
                    break;
                case "4.2":
                    petCardIndex.sort(new PetOwnerComparator());
                    displayPetCardIndexInConsole(petCardIndex);
                    break;
                case "4.3":
                    petCardIndex.sort(new PetWeightComparator());
                    displayPetCardIndexInConsole(petCardIndex);
                    break;
                case "5":
                    displayPetCardIndexInConsole(petCardIndex);
                    break;
                default:
                    break;
            }
            System.out.println("Keep editing? n - no, other - yes");
            keepEditing = !input.next().equals("n");
        }

    }

    public static PetCardIndex initializePetCardIndexFromConsole(){
        PetCardIndex petCardIndex = new PetCardIndex();
        boolean keep = true;
        Scanner input = new Scanner(System.in);
        while(keep){
            Pet newPet = initializePetFromConsole();
            petCardIndex.add(newPet);
            System.out.println("Keep adding? y - yes");
            keep = input.next().equals("y");
        }

        return petCardIndex;
    }

    public static Pet initializePetFromConsole(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter pet's name");
        String petName = input.next();
        Person petOwner = initializeOwnerFromConsole();
        System.out.println("Enter pet's weight");
        double petWeight = input.nextDouble();
        return new Pet(petName, petOwner, petWeight);
    }

    public static Person initializeOwnerFromConsole(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter owner info(age, sex, name)");
        System.out.print("Age: ");
        int ownerAge = input.nextInt();
        System.out.print("Sex: ");
        String ownerSex = input.next();
        System.out.print("Name: ");
        String ownerName = input.next();
        return new Person(ownerAge, ownerSex, ownerName);
    }

    public static void displayPetCardIndexInConsole(PetCardIndex petCardIndex){
        System.out.println("Pet list:");
        for(Pet pet: petCardIndex){
            System.out.println(pet.toString());
        }
    }
}
