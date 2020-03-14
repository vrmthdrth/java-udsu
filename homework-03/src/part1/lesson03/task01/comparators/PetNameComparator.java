package part1.lesson03.task01.comparators;

import part1.lesson03.task01.entities.Pet;

import java.util.Comparator;

/**
 * A comparator class containing methods to compare Pet objects by Name property.
 */
public class PetNameComparator implements Comparator<Pet> {
    /**
     * An overriding of compare method. Compares by Name property.
     * @param first First Pet object to compare
     * @param second Second Pet object to compare
     * @return 1 if first > second. -1 if first < second. 0 if first == second
     */
    @Override
    public int compare(Pet first, Pet second) {
        if(first.getName().compareTo(second.getName()) > 0){
            return 1;
        }
        else if(first.getName().compareTo(second.getName()) < 0){
            return -1;
        }
        return 0;
    }
}
