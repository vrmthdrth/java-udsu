package part1.lesson03;

import part1.lesson03.task01.entities.Pet;

import java.util.*;

public class PetCardIndex {

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

        if(this.values != null && this.values.contains(pet)){
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
      //  int index = this.values.indexOf(this.getValueById(id));
        this.getValueById(id).setName(newName);
    }

    private boolean isIdUnique(int id){
        for(Pet pet: this.values){
            if(pet.getId() == id){
                return false;
            }
        }
        return true;
    }

    public PetCardIndex sort(){



        return this;
    }

}


