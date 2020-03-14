package part1.lesson03;

import part1.lesson03.task01.entities.Person;
import part1.lesson03.task01.entities.Pet;

import java.util.Scanner;
import java.util.UUID;

public class Helper {

    public static void mainProcedure(){

        PetCardIndex petCardIndex = initializePetCardIndexFromConsole();
        displayPetCardIndexInConsole(petCardIndex);
        boolean keepEditing = true;
        while(keepEditing){
            Scanner input = new Scanner(System.in);
            System.out.println("what you want to do(1 - add pet, 2 - find by Name, 3.1 - change name by Id, 3.2 - change owner by Id, 3.3 - change weight by Id, 4 - sort and display, 5 - display, 6 - skip)");
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
                case "4":
                   // petCardIndex.sort();
                    displayPetCardIndexInConsole(petCardIndex);
                    break;
                case "5":
                    displayPetCardIndexInConsole(petCardIndex);
                    break;
                default:
                    break;
            }
            System.out.println("Keep editing? y - yes");
            keepEditing = input.next().equals("y");
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
