package part1.lesson03.task01.comparators;

import part1.lesson03.task01.entities.Pet;

import java.util.Comparator;

public class PetOwnerComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet first, Pet second) {
        if(first.getOwner().getName().compareTo(second.getOwner().getName()) > 0){
            return 1;
        }
        else if(first.getOwner().getName().compareTo(second.getOwner().getName()) < 0){
            return -1;
        }
        return 0;
    }
}
