package part1.lesson03.task01.comparators;

import part1.lesson03.task01.entities.Pet;

import java.util.Comparator;

/**
 * A comparator class containing methods to compare Pet objects by Owner's Name(Person object) property.
 */
public class PetOwnerComparator implements Comparator<Pet> {
    /**
     * An overriding of compare method. Compares by Owner's Name property.
     * @param first First Pet object to compare
     * @param second Second Pet object to compare
     * @return 1 if first > second. -1 if first < second. 0 if first == second
     */
    @Override
    public int compare(Pet first, Pet second) {
        return first.getOwner().getName().compareTo(second.getOwner().getName());
    }
}
