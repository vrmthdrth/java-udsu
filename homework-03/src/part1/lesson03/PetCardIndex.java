package part1.lesson03;

import part1.lesson03.task01.entities.Person;
import part1.lesson03.task01.entities.Pet;

import java.util.*;

public class PetCardIndex extends ArrayList<Pet>{

    @Override
    public boolean add(Pet pet) {
        if(super.contains(pet)){
            throw new IllegalArgumentException("This pet is not unique in collection");
        }
        else{
            return super.add(pet);
        }
    }

    public Pet getPetByName(String petName){
        for(Pet pet: this){
            if(pet.getName().equals(petName)){
                return pet;
            }
        }
        throw new IllegalArgumentException("This collection does not contain any pet with Name: " + petName);
    }

    public void setPetNameByUUID(UUID id, String newName){
        this.getPetByUUID(id).setName(newName);
    }

    public void setPetOwnerByUUID(UUID id, Person newOwner){
        this.getPetByUUID(id).setOwner(newOwner);
    }

    public void setPetWeightByUUID(UUID id, double newWeight){
        this.getPetByUUID(id).setWeight(newWeight);
    }

    private Pet getPetByUUID(UUID id){
        for(Pet pet: this){
            if(id.equals(pet.getId())){
                return pet;
            }
        }
        throw new IllegalArgumentException("This collection does not contain any pet with Id: " + id);
    }

    @Override
    public void sort(Comparator<? super Pet> c) {
        super.sort(c);
    }
}