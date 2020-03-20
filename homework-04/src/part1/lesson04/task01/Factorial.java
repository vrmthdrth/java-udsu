package part1.lesson04.task01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Factorial{
    public static BigInteger compute(int number){
        BigInteger result = BigInteger.valueOf(1);
        for(int i = 1; i <= number; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static List<BigInteger> computeFactorialsForIntegerArray(int[] array) throws ExecutionException, InterruptedException {
        List<Future<BigInteger>> futureList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        for(int i = 0; i < array.length; i++){
            final int value = array[i];
            futureList.add(CompletableFuture.supplyAsync(() -> Factorial.compute(value), executorService));
        }
        executorService.shutdown();
        return getFutureValues(futureList);
    }

    public static List<BigInteger> getFutureValues(List<Future<BigInteger>> futureList) throws ExecutionException, InterruptedException {
        List<BigInteger> values = new ArrayList<>();
        for(Future<BigInteger> future: futureList){
            values.add(future.get());
        }
        return values;
    }
}