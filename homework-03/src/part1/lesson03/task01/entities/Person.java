package part1.lesson03.task01.entities;

/**
 * A class containing properties and methods for Person objects.
 * Contains such properties as <b>age</b>, <b>sex</b> and <b>name</b>.
 */
public class Person {
    /**
     * An age property
     */
    private int age;

    /**
     * A sex property
     */
    private Sex sex;

    /**
     * A name property
     */
    private String name;

    /**
     * Gets an {@link Person#age} value
     * @return Age of person
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Gets an {@link Person#sex} value
     * @return Sex of person
     */
    public Sex getSex() {
        return this.sex;
    }

    /**
     * Gets an {@link Person#name} value
     * @return Name of person
     */
    public String getName(){
        return this.name;
    }

    /**
     * Sets a value of {@link Person#age} property
     * @param ageValue Age
     */
    public void setAge(int ageValue) {
        if(ageValue > 100 || ageValue < 0){
            throw new IndexOutOfBoundsException("Age value must be in [0,100] range.");
        }
        else{
            this.age = ageValue;
        }
    }

    /**
     * Sets a value of {@link Person#sex} property
     * @param sexValue Sex
     */
    public void setSex(String sexValue) {
        this.sex = new Sex(sexValue);
    }

    /**
     * Sets a value of {@link Person#name} property
     * @param nameValue Name
     */
    public void setName(String nameValue) {
        if(nameValue.matches("[a-zA-Z]+")){
            this.name = nameValue;
        }
        else{
            throw new IllegalArgumentException("Name can contain latin letters only.");
        }
    }

    /**
     * Default constructor
     * Creates an instance of Person class
     */
    public Person() {

    }

    /**
     * Constructor with parameters
     * Creates an instance of Person class
     * @param ageValue Age
     * @param sexValue Sex
     * @param nameValue Name
     */
    public Person(int ageValue, String sexValue, String nameValue) {
        this.setAge(ageValue);
        this.setSex(sexValue);
        this.setName(nameValue);
    }

    /**
     * An overriding of Object.toString() method
     * @return A string representation of Person class objects
     */
    @Override
    public String toString() {
        return "Age: " + this.age + ", Sex: " + this.sex.getValue() + ", Name: " + this.name;
    }
}
