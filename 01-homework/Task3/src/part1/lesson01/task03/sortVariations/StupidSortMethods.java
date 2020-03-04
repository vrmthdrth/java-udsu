package part1.lesson01.task03.sortVariations;

import part1.lesson01.task03.IPersonSort;
import part1.lesson01.task03.entities.Person;
import part1.lesson01.task03.SortHelper;

/**
 * A class containing stupid sort methods of sorting Person objects arrays
 */
public class StupidSortMethods implements IPersonSort {
    /**
     * A stupid sort method in "men are first" order
     * @param personArray Person objects array
     * @return Sorted array
     */
    @Override
    public Person[] menFirst(Person[] personArray) {
        boolean needIteration = true;
        while(needIteration){
            needIteration = false;
            for(int i = 1; i < personArray.length; i++){
                if(personArray[i].getSex().toString().equals("man") && personArray[i - 1].getSex().toString().equals("woman") ){
                    SortHelper.swapCurrentPersonWithPrevious(personArray, i);
                    needIteration = true;
                }
            }
        }
        return personArray;
    }

    /**
     * A stupid sort method in descending by age order
     * @param personArray Person objects array
     * @return Sorted array
     */
    @Override
    public Person[] descendingByAge(Person[] personArray) {
        boolean needIteration = true;
        while(needIteration){
            needIteration = false;
            for(int i = 1; i < personArray.length; i++){
                if((personArray[i - 1].getAge()) < personArray[i].getAge()){
                    SortHelper.swapCurrentPersonWithPrevious(personArray, i);
                    needIteration = true;
                }
            }
        }
        return personArray;
    }

    /**
     * A stupid sort method in ascending by alphabet order
     * Array is sorted by names
     * @param personArray Person objects array
     * @return Sorted array
     */
    @Override
    public Person[] ascendingByAlphabet(Person[] personArray) {
        boolean needIteration = true;
        while(needIteration){
            needIteration = false;
            for(int i = 1; i < personArray.length; i++){
                if((personArray[i - 1].getName().compareTo(personArray[i].getName())) > 0){
                    SortHelper.swapCurrentPersonWithPrevious(personArray, i);
                    needIteration = true;
                }
            }
        }
        return personArray;
    }
}
