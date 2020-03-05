package part1.lesson01;

import part1.lesson01.task01.ExceptionsClassTask;
import part1.lesson01.task02.Methods;
import part1.lesson01.task03.SortHelper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose the task: 1 - task01, 2 - task02, 3 - task03");
        Scanner input = new Scanner(System.in);
        switch(input.nextInt()){
            case 1:
                ExceptionsClassTask.helloWorld();
                break;
            case 2:
                Methods.mainCommand();
                break;
            case 3:
                SortHelper.mainCommand();
                break;
            default:
                System.out.println("bye");
                break;
        }
    }
}
