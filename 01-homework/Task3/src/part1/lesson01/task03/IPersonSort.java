package part1.lesson01.task03;

/**
 * An interface that contains methods of sorting Person objects array.
 */
public interface IPersonSort {
    /**
     * A method of sorting in "Men are first" order
     * @param personArray Person objects array
     * @return Sorted array
     */
    public Person[] menFirst(Person[] personArray);

    /**
     * A method of sorting in descending by age order
     * @param personArray Person objects array
     * @return Sorted array
     */
    public Person[] descendingByAge(Person[] personArray);

    /**
     * A method of sorting in ascending by alphabet order
     * Array is sorted by names
     * @param personArray Person objects array
     * @return Sorted array
     */
    public Person[] ascendingByAlphabet(Person[] personArray);
}
