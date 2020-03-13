package part1.lesson03;

import part1.lesson03.task01.entities.Person;
import part1.lesson03.task01.entities.Pet;

public class Main {

    public static void main(String[] args) {
        Person dude = new Person(44, "man", "Sigizmund");
        Pet sabaka = new Pet(93913, "Hudson", dude, 33);
        PetCardIndex pci = new PetCardIndex();
        pci.addValue(sabaka);
       // pci.addValue(sabaka);
        for(Pet pet: pci.getValues()){
            System.out.println(pet.toString());
        }
    }
}
