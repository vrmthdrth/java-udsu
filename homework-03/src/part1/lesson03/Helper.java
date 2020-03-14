package part1.lesson03;

import part1.lesson03.task01.entities.Person;
import part1.lesson03.task01.entities.Pet;

import java.util.Scanner;

public class Helper {
    public PetCardIndex initializePetCardIndexFromConsole(){
        PetCardIndex petCardIndex = new PetCardIndex();
        boolean keep = true;
        Scanner input = new Scanner(System.in);
        while(keep){
            System.out.println("Enter Id");
            int id = input.nextInt();
            System.out.println("Enter name");
            String name = input.next();

            System.out.println("Enter owner info");

            Person owner = new Person();

            System.out.println("Enter weight");
            int weight = input.nextInt();


        }

        return new PetCardIndex();
    }
}
