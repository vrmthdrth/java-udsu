package part1.lesson03;

import part1.lesson03.task01.entities.Pet;

import java.util.List;

public class PetCardIndex {

   public List<Pet> values;

    public PetCardIndex(){

    }

    public PetCardIndex(List<Pet> petList){
        this.values = petList;
    }

    public List<Pet> getValues(){
        return this.values;
    }

    public void setValues(List<Pet> petList){
        this.values = petList;
    }

    public Pet getValueById(int id){
        return this.values.get(id);
    }

    public Pet getValueByName(String name){
        for(Pet pet: this.values){
            if(pet.)
        }
    }

    public void setValueById(int id){
        for(Pet pet: this.values){

        }
    }


    public void setValue(int id, Pet pet){
        this.values.set(id, pet);
    }

    public void addValue(Pet pet){

        if(this.values.contains(pet)){
            throw new IllegalArgumentException("Input Pet already is contain in PetCardIndex.values");
        }
        else{
            this.values.add(pet);
        }

    }

}
