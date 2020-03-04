package part1.lesson01.task03.sortVariations;

import part1.lesson01.task03.IPersonSort;
import part1.lesson01.task03.entities.Person;
import part1.lesson01.task03.SortHelper;

/**
 * A class containing bubble sort methods of sorting Person objects arrays
 */
public class BubbleSortMethods implements IPersonSort {
    /**
     * A bubble sort method in "men are first" order
     * @param personArray Person objects array
     * @return Sorted array
     */
    @Override
    public Person[] menFirst(Person[] personArray) {
        for(int i = 0; i < personArray.length; i++){
            for(int j = 1; j < personArray.length; j++){
                if((personArray[j - 1].getSex().toString().equals("woman") && personArray[j].getSex().toString().equals("man"))){
                    SortHelper.swapCurrentPersonWithPrevious(personArray, j);
                }
            }
        }
        return personArray;
    }

    /**
     * A bubble sort method in descending by age order
     * @param personArray Person objects array
     * @return Sorted array
     */
    @Override
    public Person[] descendingByAge(Person[] personArray) {
        for(int i = 0; i < personArray.length; i++){
            for(int j = 1; j < personArray.length; j++){
                if((personArray[j - 1].getAge()) < personArray[j].getAge()){
                    SortHelper.swapCurrentPersonWithPrevious(personArray, j);
                }
            }
        }
        return personArray;
    }

    /**
     * A bubble sort method in ascending by alphabet order
     * Array is sorted by names
     * @param personArray Person objects array
     * @return Sorted array
     */
    @Override
    public Person[] ascendingByAlphabet(Person[] personArray) {
        for(int i = 0; i < personArray.length; i++){
            for(int j = 1; j < personArray.length; j++){
                if((personArray[j - 1].getName().compareTo(personArray[j].getName())) > 0){
                    SortHelper.swapCurrentPersonWithPrevious(personArray, j);
                }
            }
        }
        return personArray;
    }
}
