package part1.lesson04.task01;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Helper {
    public static int[] generateRandomIntegerArray(int arraySize){
        int[] randomArray = new int[arraySize];
        for(int i = 0; i < arraySize; i++){
            randomArray[i] = (int)(Math.random() * 100);
        }
        return randomArray;
    }

    public static void displayResult(int[] originalArray, List<BigInteger> bigIntegerList){
        Iterator iterator = bigIntegerList.iterator();
        for(int originalValue: originalArray){
            System.out.println(originalValue + "! = " + iterator.next());
        }
    }

    public static void mainProcedure() throws ExecutionException, InterruptedException {
        int[] randomArray = Helper.generateRandomIntegerArray(1000);
        List<BigInteger> resultList = Factorial.computeFactorialsForIntegerArray(randomArray);
        Helper.displayResult(randomArray, resultList);
    }
}
