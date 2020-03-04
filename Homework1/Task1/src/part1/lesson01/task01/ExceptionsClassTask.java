package part1.lesson01.task01;

import java.util.Scanner;

/**
 * A class containing different methods.
 */
public class ExceptionsClassTask {

    /**
     * A method that throws different exceptions.
     */
    public static void HelloWorld(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите\n 1 для вызова ArrayIndexOutOfBoundsException\n 2 для вызова NullPointerException\n 3 для вызова IllegalArgumentException\n");
        while(true){
            switch(input.next()){
                case "1":
                    int[] array = new int[10];
                    System.out.println(array[10]);
                    break;
                case "2":
                    ((Object)null).toString();
                    break;
                case "3":
                    throw new IllegalArgumentException();
                default:
                    System.out.println("Введите одно из предложенных чисел.");
            }
        }
    }

}
