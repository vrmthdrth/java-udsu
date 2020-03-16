package part1.lesson01.task01;

import java.util.Scanner;

/**
 * A class containing different methods.
 */
public class ExceptionsTask {
    /**
     * A method that throws different exceptions.
     */
    public static void helloWorld() throws HelloWorldException{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter\n 1 to throw ArrayIndexOutOfBoundsException()\n 2 to throw NullPointerException()\n 3 to throw HelloWorldException()\n");
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
                    throw new HelloWorldException();
                default:
                    System.out.println("Hello, World!");
                    break;
            }
        }
    }
}
