package part1.lesson03.task01.petCardIndex;

import part1.lesson03.task01.entities.Person;
import part1.lesson03.task01.entities.Pet;

import java.util.*;

/**
 * A class designed to store a list of Pet objects
 */
public class PetCardIndex extends ArrayList<Pet>{

    /**
     * An overriding of ArrayList.add method
     * @param pet A pet to add
     * @return true if collection was changed successfully and false in the opposite
     */
    @Override
    public boolean add(Pet pet) {
        if(super.contains(pet) || !this.isIdUnique(pet.getId()) || !this.isNameUnique(pet.getName())){
            throw new IllegalArgumentException("This pet is not unique in collection");
        }
        else{
            return super.add(pet);
        }
    }

    /**
     * A method to get Pet by Name from collection.
     * @param petName Name of Pet
     * @return Pet
     */
    public Pet getPetByName(String petName){
        for(Pet pet: this){
            if(pet.getName().equals(petName)){
                return pet;
            }
        }
        throw new IllegalArgumentException("This collection does not contain any pet with Name: " + petName);
    }

    /**
     * Method to set Pet Name by UUID.
     * @param id UUID.
     * @param newName New name
     */
    public void setPetNameByUUID(UUID id, String newName){
        if(!this.isNameUnique(newName) || this.getPetByUUID(id).getName().equals(newName)){
            throw new IllegalArgumentException("New name is not unique in this list.");
        }
        this.getPetByUUID(id).setName(newName);
    }

    /**
     * Method to set Pet Owner by UUID.
     * @param id UUID.
     * @param newOwner New Owner
     */
    public void setPetOwnerByUUID(UUID id, Person newOwner){
        this.getPetByUUID(id).setOwner(newOwner);
    }

    /**
     * Method to set Pet Weight by UUID.
     * @param id UUID
     * @param newWeight New Weight
     */
    public void setPetWeightByUUID(UUID id, double newWeight){
        this.getPetByUUID(id).setWeight(newWeight);
    }

    /**
     * Method to get Pet object from collection by UUID.
     * @param id UUID.
     * @return Pet
     */
    private Pet getPetByUUID(UUID id){
        for(Pet pet: this){
            if(id.equals(pet.getId())){
                return pet;
            }
        }
        throw new IllegalArgumentException("This collection does not contain any pet with Id: " + id);
    }

    /**
     * Method that checks if input UUID is unique in collection
     * @param id UUID
     * @return true if UUID is unique and false in the opposite
     */
    public boolean isIdUnique(UUID id){
        for(Pet pet: this){
            if(pet.getId().equals(id)){
                return false;
            }
        }
        return true;
    }

    /**
     * Method that checks if input Name is unique in collection
     * @param name Name
     * @return true if Name is unique and false in the opposite
     */
    public boolean isNameUnique(String name){
        for(Pet pet: this){
            if(pet.getName().equals(name)){
                return false;
            }
        }
        return true;
    }

    /**
     * An overriding of ArrayList.sort method
     * @param comparator A specific comparator
     */
    @Override
    public void sort(Comparator<? super Pet> comparator) {
        super.sort(comparator);
    }
}