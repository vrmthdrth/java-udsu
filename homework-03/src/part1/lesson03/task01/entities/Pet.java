package part1.lesson03.task01.entities;

import java.util.UUID;

/**
 * A class containing properties and methods for Pet objects.
 * Contains such properties as <b>id</b>, <b>name</b>, <b>owner</b> and <b>weight</b>.
 */
public class Pet {
    /**
     * A property defining unique ID for concrete Pet class instance.
     */
    private UUID id;

    /**
     * A property defining name of Pet.
     */
    private String name;

    /**
     * A property defining owner of Pet.
     */
    private Person owner;

    /**
     * A property defining weight of Pet.
     */
    private double weight;

    /**
     * Creates a new instance of Pet class.
     * @param petName Name of pet
     * @param personOwner Owner of pet
     * @param petWeight Weight of pet
     */
    public Pet(String petName, Person personOwner, double petWeight){
        this.id = UUID.randomUUID();
        this.name = petName;
        this.owner = personOwner;
        this.weight = petWeight;
    }

    /**
     * Gets an ID property value.
     * @return Identifier
     */
    public UUID getId(){
        return this.id;
    }

    /**
     * Gets a Name property value.
     * @return Name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets a Owner property value.
     * @return Owner as a Person object
     */
    public Person getOwner(){
        return this.owner;
    }

    /**
     * Gets a Weight property value.
     * @return Weight
     */
    public double getWeight(){
        return this.weight;
    }

    /**
     * Sets a new Name property value.
     * @param newName New name
     */
    public void setName(String newName){
        this.name = newName;
    }

    /**
     * Sets a new Owner property value
     * @param newOwner New owner
     */
    public void setOwner(Person newOwner){
        this.owner = newOwner;
    }

    /**
     * Sets a new Weight property value
     * @param newWeight
     */
    public void setWeight(double newWeight){
        this.weight = newWeight;
    }

    /**
     * An overriding of Object.toString() method
     * @return A String representation of Pet object
     */
    @Override
    public String toString() {
        return "Id: " + this.id + ", Name: " + this.name + ", Owner: " + this.owner.getName() + ", Weight: " + this.weight;
    }
}
