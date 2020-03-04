package part1.lesson01.task02;

import java.util.Scanner;

/**
 * A class containing different methods.
 */
public class Methods {

    /**
     * A method that initializes new array and
     */
    public static void findNumbers(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input N:");
        int N = input.nextInt(); //next
        int[] randomNumbers = new int[N];
        for(int i = 0; i < N; i++){
            randomNumbers[i] = (int)((Math.random() * 200) - 100);
        }
        System.out.println("There's probable result:");
        for(Integer k: randomNumbers){
            Double q = Math.sqrt(k);
            Double tmp = Math.sqrt(k * (-1));
            if(q.isNaN()){
                throw new ArithmeticException("Exception for q = " + q + " where k is " + k);
            }
            else if(q.intValue() * q.intValue()  == k){
                System.out.println(q.intValue() + " where k is " + k);
            }
        }
    }
}
