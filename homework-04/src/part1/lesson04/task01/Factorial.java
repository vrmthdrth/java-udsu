package part1.lesson04.task01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Contains static methods which are necessary to compute factorials
 */
public class Factorial{
    /**
     * Computes a factorial of integer number
     * @param number Number
     * @return Result as a BigInteger instance
     */
    public static BigInteger compute(int number){
        BigInteger result = BigInteger.valueOf(1);
        for(int i = 1; i <= number; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Computes factorials of every number from input integer array
     * @param array Array
     * @return Result as a List of BigInteger
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static List<BigInteger> computeFactorialsForIntegerArray(int[] array) throws ExecutionException, InterruptedException {
        List<Future<BigInteger>> futureList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        for(int value: array){
            futureList.add(CompletableFuture.supplyAsync(() -> Factorial.compute(value), executorService));
        }
        executorService.shutdown();
        return getFutureValues(futureList);
    }

    /**
     * Gets values from list of futures. Writes them into List of BigInteger
     * @param futureList Future list
     * @return List of BigInteger
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static List<BigInteger> getFutureValues(List<Future<BigInteger>> futureList) throws ExecutionException, InterruptedException {
        List<BigInteger> values = new ArrayList<>();
        for(Future<BigInteger> future: futureList){
            values.add(future.get());
        }
        return values;
    }
}