package part1.lesson01.task02;

import java.util.Scanner;

/**
 * A class containing different methods.
 */
public class SquareRootsTask {
    /**
     * A procedure to execute in main()
     */
    public static void mainCommand(){
        int[] randomArray = initializeAndDisplayIntegerArray();
        findNumbers(randomArray);
    }

    /**
     * Initializes new integer array with values in integer range [-100, 100]
     * @return Array
     */
    public static int[] initializeAndDisplayIntegerArray(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input array size:");
        int arraySize = input.nextInt();
        int[] randomNumbers = new int[arraySize];
        for(int i = 0; i < arraySize; i++){
            randomNumbers[i] = (int)((Math.random() * 200) - 100);
        }
        System.out.println("Array:");
        for(int number: randomNumbers){
            System.out.print(" " + number);
        }
        System.out.println();
        return randomNumbers;
    }

    /**
     * A method that calculates the root of each element of the array
     * and displays it in the console if the square of the integer part
     * of this root is equal to the number from which it was calculated
     * Throws an exception when trying to calculate the root of a negative number
     * @param array Array
     */
    public static void findNumbers(int[] array){
        for(int k: array){
            Double q = Math.sqrt(k);
            if(q.isNaN()){
                throw new ArithmeticException("An attempt to take a real root from a negative number");
            }
            else if(q.intValue() * q.intValue()  == k){
                System.out.println("q = " + q.intValue() + ", k = " + k);
            }
        }
    }
}
