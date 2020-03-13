package part1.lesson03.task01.entities;

/**
 * A class containing properties and methods for Sex objects
 * Contains such properties as <b>MAN</b>, <b>WOMAN</b> and <b>value</b>
 */
public class Sex {
    /**
     * A string constant defining male gender
     */
    private static final String MAN = "man";

    /**
     * A string constant defining female gender
     */
    private static final String WOMAN = "woman";

    /**
     * A property defining a sex of a concrete object
     */
    private String value;

    /**
     * Gets a {@link Sex#value} value
     * @return Value of Sex
     */
    public String getValue(){
        return this.value;
    }

    /**
     * Constructor with parameters
     * Creates an instance of a Sex class
     * @param sex Sex
     */
    public Sex(String sex){
        switch (sex){
            case "man":
                this.value = this.MAN;
                break;
            case "woman":
                this.value = this.WOMAN;
                break;
            default:
                throw new IllegalArgumentException("'man' or 'woman' values allowed only.");
        }
    }

    /**
     * An overriding of Object.toString() method
     * @return {@link Sex#value}
     */
    @Override
    public String toString() {
        return this.value;
    }
}
