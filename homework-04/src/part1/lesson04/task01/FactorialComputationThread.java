package part1.lesson04.task01;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class FactorialComputationThread implements Callable<BigInteger> {

    private int numberToCompute;

    public FactorialComputationThread(int number){
        this.numberToCompute = number;
    }

    @Override
    public BigInteger call() throws Exception {
        return Factorial.compute(this.numberToCompute);
    }
}