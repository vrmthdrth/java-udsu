package part1.lesson04.task01;

import java.math.BigInteger;

public class Factorial{
    public static BigInteger compute(int number){
        BigInteger result = BigInteger.valueOf(1);
        for(int i = 1; i <= number; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
    //    System.out.println("Текущий поток: " + Thread.currentThread().getId());
        return result;
    }
}