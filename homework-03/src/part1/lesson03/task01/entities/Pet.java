package part1.lesson03.task01.entities;

public class Pet {

    private int id;
    private String name;
    private Person owner;
    private double weight;

    public Pet(int uniqueId, String petName, Person personOwner, double petWeight){
        this.id = uniqueId;
        this.name = petName;
        this.owner = personOwner;
        this.weight = petWeight;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Person getOwner(){
        return this.owner;
    }

    public double getWeight(){
        return this.weight;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setOwner(Person newOwner){
        this.owner = newOwner;
    }

    public void setWeight(double newWeight){
        this.weight = newWeight;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " Name: " + this.name + " Owner: " + this.owner.getName() + " Weight: " + this.weight;
    }
}
