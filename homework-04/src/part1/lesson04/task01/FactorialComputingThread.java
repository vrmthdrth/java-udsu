package part1.lesson04.task01;

import part1.lesson04.task01.Factorial;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class FactorialComputingThread implements Callable<BigInteger> {

    private int numberToCompute;

    public FactorialComputingThread(int number){
        this.numberToCompute = number;
    }

    @Override
    public BigInteger call() throws Exception {
        return Factorial.compute(this.numberToCompute);
    }

}