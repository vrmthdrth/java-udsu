package part1.lesson04.task01;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Class containing necessary static methods.
 */
public class Helper {
    /**
     * Generates random integer array.
     * @param arraySize Size of array
     * @return New random array
     */
    public static int[] generateRandomIntegerArray(int arraySize){
        int[] randomArray = new int[arraySize];
        for(int i = 0; i < arraySize; i++){
            randomArray[i] = (int)(Math.random() * 100);
        }
        return randomArray;
    }

    /**
     * Displays result of calculation.
     * @param originalArray Original array
     * @param bigIntegerList Result of calculation
     */
    public static void displayResult(int[] originalArray, List<BigInteger> bigIntegerList){
        Iterator iterator = bigIntegerList.iterator();
        for(int originalValue: originalArray){
            System.out.println(originalValue + "! = " + iterator.next());
        }
    }

    /**
     * A procedure to execute in main().
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void mainProcedure() throws ExecutionException, InterruptedException {
        int[] randomArray = Helper.generateRandomIntegerArray(1000);
        List<BigInteger> resultList = Factorial.computeFactorialsForIntegerArray(randomArray);
        Helper.displayResult(randomArray, resultList);
    }
}
