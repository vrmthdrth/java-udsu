package part1.lesson03.task01.entities;

public class Pet {
    private int id;
    private String name;
    private Person owner;
    private double weight;

    public Pet(int uniqueId, String petName, Person personOwner, double petWeight){
        this.id = uniqueId;
        this.name = petName;
        this.owner = personOwner;// new Person(personOwner.getAge(),personOwner.getSex().getValue(), personOwner.getName());
        this.weight = petWeight;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int newId){
        //isIdUnique
        this.id = newId;
    }

    public void changeInformationById(){

    }

}
