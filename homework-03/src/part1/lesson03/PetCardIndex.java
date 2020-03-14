package part1.lesson03;

import part1.lesson03.task01.entities.Person;
import part1.lesson03.task01.entities.Pet;

import java.util.*;

/*public class PetCardIndex {

    private ArrayList<Pet> values = new ArrayList<>();

    public PetCardIndex(){

    }

    public PetCardIndex(ArrayList<Pet> petList){
        this.values = petList;
    }

    public ArrayList<Pet> getValues(){
        return this.values;
    }

    private int getIndexById(int id){
        for(Pet pet: this.values){
            if(pet.getId() == id){
                return this.values.indexOf(pet);
            }
        }
        throw new IllegalArgumentException();
    }

    public Pet getValueById(int id){
        for(Pet pet: this.values){
            if(pet.getId() == id){
                return pet;
            }
        }
        throw new IllegalArgumentException();
    }

    public void addValue(Pet pet){
        if(this.values.contains(pet) || this.isIdUnique(pet.getId()) || this.isNameUnique(pet.getName())){
            throw new IllegalArgumentException("Input Pet is already contain in PetCardIndex.values");
        }
        else{
            this.values.add(pet);
        }

    }

    public Pet getValueByName(String name){
        for(Pet pet: this.values){
            if(pet.getName().equals(name)){
                return pet;
            }
        }
        throw new IllegalArgumentException();
    }

    public void changeNameById(int id, String newName){
        this.getValueById(id).setName(newName);
    }

    public void changeOwnerById(int id, Person newOwner){
        this.getValueById(id).setOwner(newOwner);
    }

    public void changeWeightById(int id, double newWeight){
        this.getValueById(id).setWeight(newWeight);
    }

    private boolean isIdUnique(int id){
        for(Pet pet: this.values){
            if(pet.getId() == id){
                return false;
            }
        }
        return true;
    }

    private boolean isNameUnique(String name){
        for(Pet pet: this.values){
            if(pet.getName().equals(name)){
                return false;
            }
        }
        return true;
    }

    public PetCardIndex sort(){



        return this;
    }

}

*/

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

    public void setPetValuesByIndex(UUID id){
        
    }

}