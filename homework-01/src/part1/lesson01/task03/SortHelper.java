package part1.lesson01.task03;

import part1.lesson01.task03.entities.Person;
import part1.lesson01.task03.sortVariations.BubbleSortMethods;
import part1.lesson01.task03.sortVariations.StupidSortMethods;

import java.util.Scanner;

/**
 * A class containing additional methods which are necessary to initialize and sort Person objects arrays
 */
public class SortHelper {
    /**
     * A method of choosing sort method depending on sorting criterion parameter
     * @param sortVar Sort criterion parameter
     * @param personArray Array of Person objects
     * @return Sorted personArray
     */
    public static Person[] sortPersonArray(SortVariations sortVar, Person[] personArray){
        switch(sortVar){
            case MEN_FIRST_BUBBLE:
                return new BubbleSortMethods().menFirst(personArray);
            case DESCENDING_BY_AGE_BUBBLE:
                return new BubbleSortMethods().descendingByAge(personArray);
            case ASCENDING_BY_ALPHABET_BUBBLE:
                return new BubbleSortMethods().ascendingByAlphabet(personArray);
            case MEN_FIRST_STUPID:
                return new StupidSortMethods().menFirst(personArray);
            case DESCENDING_BY_AGE_STUPID:
                return new StupidSortMethods().descendingByAge(personArray);
            case ASCENDING_BY_ALPHABET_STUPID:
                return new StupidSortMethods().ascendingByAlphabet(personArray);
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * A method of initialization of new Person objects array through the console
     * @param arraySize Size of array
     * @return Initialized array
     */
    public static Person[] initializePersonArray(int arraySize){
        if(arraySize <= 0){
            throw new IndexOutOfBoundsException("arraySize parameter cant be less than 1");
        }
        Person[] personArray = new Person[arraySize];
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < personArray.length; i++){
            boolean keep = true;
            while(keep){
                System.out.println("Left: " + (personArray.length - i) + " persons");
                System.out.print("Age: ");
                int age = input.nextInt();
                System.out.print("Sex: ");
                String sex = input.next();
                System.out.print("Name: ");
                String name = input.next();
                personArray[i] = new Person(age, sex, name);
                keep = !areAgeAndNameUnique(personArray, i);
                if(keep){
                    System.out.println("Exception: Age and Name values must be unique in array.");
                }
            }
        }
        return personArray;
    }

    /**
     * A method of initialization of new Person objects array with random values(and unique Age & Name pairs)
     * Where:
     * Age is random integer number in range [0, 100]
     * Sex is random value "male" or "female"
     * Name is random word which length is integer in range [2, 10] with random letters from latin alphabet
     * @param arraySize Size of array
     * @return Initialized array
     */
    public static Person[] initializeRandomPersonArray(int arraySize){
        if(arraySize <= 0){
            throw new IndexOutOfBoundsException("arraySize parameter cant be less than 1");
        }
        Person[] personArray = new Person[arraySize];
        char[] upperLettersArray = "ABCDEFGHIGKLMNOPQRSTUVWXYZ".toCharArray();
        char[] lowerLettersArray = "abcdefghigklmnopqrstuvwxyz".toCharArray();
        for(int i = 0; i < personArray.length; i++){
            boolean keep = true;
            while(keep){
                int randWordLength = (int)(Math.random() * 9) + 2;
                String randName = "";
                for(int cnt = 0; cnt < randWordLength; cnt++){
                    randName += (cnt != 0) ? lowerLettersArray[(int)(Math.random() * 26)] : upperLettersArray[(int)(Math.random() * 26)];
                }
                int randAge = (int)(Math.random() * 101);
                String randSex = "";
                randSex = (int)((Math.random() * 200) - 100) >= 0 ? "man" : "woman";
                personArray[i] = new Person(randAge, randSex, randName);
                keep = !areAgeAndNameUnique(personArray, i);
            }
        }
        return personArray;
    }

    /**
     * A method that displays initialized array of Person objects in console
     * @param personArray Person objects array
     */
    public static void displayPersonArray(Person[] personArray){
        for(Person person: personArray){
            System.out.println(person.toString());
        }
    }

    /**
     * A method that swaps current Person from array with previous
     * @param personArray Person objects array
     * @param index Index of current Person
     */
    public static void swapCurrentPersonWithPrevious(Person[] personArray, int index){
        if(index <= 0){
            throw new IndexOutOfBoundsException("'index' parameter can not be less than 1");
        }
        Person bubblePerson = personArray[index - 1];
        personArray[index - 1] = personArray[index];
        personArray[index] = bubblePerson;
    }

    /**
     * A method that returns a result of checking if there another Age and Name pairs in Person objects values in array
     * @param personArray A Person objects array
     * @param i An index of Person object to compare with every Person objects in integer range [0, i - 1]
     * @return "true" if this pair is unique, "false" in the opposite case
     */
    public static boolean areAgeAndNameUnique(Person[] personArray, int i){
        if(i < 0) {
            throw new IllegalArgumentException("Array index can not be negative.");
        }
        else{
            for(int j = 0; j < i ; j++){
                if(personArray[i].getAge() == personArray[j].getAge() && personArray[i].getName().equals(personArray[j].getName())){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * A procedure to execute in main() method
     */
    public static void mainCommand(){
        System.out.println("Enter a number of Person objects array.");
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Person[] personArray;
        System.out.println("Choose a way of initialization(1 - from console, 2 - randomly, other - randomly)");
        int M = input.nextInt();
        switch(M){
            case 1:
                personArray = initializePersonArray(N);
                displayPersonArray(personArray);
                break;
            case 2:
                personArray = initializeRandomPersonArray(N);
                displayPersonArray(personArray);
                break;
            default:
                personArray = initializeRandomPersonArray(N);
                System.out.println("Wrong... Random array initialized...");
                break;
        }
        boolean keepSorting = true;
        while(keepSorting){
            System.out.println("Choose a way of sort: (1 - bubble MEN FIRST, 2 - bubble DESCENDING AGE, 3 - bubble ASCENDING NAMES, 4 - stupid MEN FIRST, 5 - stupid DESCENDING AGE, 6 - stupid ASCENDING NAMES, other - EXIT)");
            String chosenSort = input.next();
            Person[] newPersonArray = new Person[personArray.length];
            for(int i = 0; i < personArray.length; i++){
                newPersonArray[i] = new Person(personArray[i].getAge(), personArray[i].getSex().toString(), personArray[i].getName());
            }
            Person[] sortedPersonArray = new Person[N];
            long start = System.currentTimeMillis();
            switch(chosenSort){
                case "1":
                    sortedPersonArray = sortPersonArray(SortVariations.MEN_FIRST_BUBBLE, newPersonArray);
                    break;
                case "2":
                    sortedPersonArray = sortPersonArray(SortVariations.DESCENDING_BY_AGE_BUBBLE, newPersonArray);
                    break;
                case "3":
                    sortedPersonArray = sortPersonArray(SortVariations.ASCENDING_BY_ALPHABET_BUBBLE, newPersonArray);
                    break;
                case "4":
                    sortedPersonArray = sortPersonArray(SortVariations.MEN_FIRST_STUPID, newPersonArray);
                    break;
                case "5":
                    sortedPersonArray = sortPersonArray(SortVariations.DESCENDING_BY_AGE_STUPID, newPersonArray);
                    break;
                case "6":
                    sortedPersonArray = sortPersonArray(SortVariations.ASCENDING_BY_ALPHABET_STUPID, newPersonArray);
                    break;
                default:
                    System.out.println("bye");
                    keepSorting = false;
                    break;
            }
            long finish = System.currentTimeMillis();
            long time = finish - start;
            if(keepSorting){
                System.out.println("Sorted array: ");
                displayPersonArray(sortedPersonArray);
                System.out.println("Total milliseconds(sort №" + chosenSort +  "): " + time + " ms");
            }
        }
    }
}
