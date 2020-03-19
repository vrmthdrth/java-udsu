package part1.lesson04;


import part1.lesson04.task01.Factorial;
import part1.lesson04.task01.FactorialComputingThread;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        int[] randomArray = generateRandomIntegerArray(1000000);
        System.out.println();

        long start = System.currentTimeMillis();

        List<Future<BigInteger>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        for(int i = 0; i < randomArray.length; i++){
           final int j = randomArray[i];
           futures.add(CompletableFuture.supplyAsync(() -> Factorial.compute(j), executorService));
           // Factorial.compute(randomArray[i]);
        }
        executorService.shutdown();

        for(Future<BigInteger> future: futures){
            future.get();//System.out.println(future.get());
        }

        long end = System.currentTimeMillis();
        long timeElapsed = end - start;

        System.out.println("Time elapsed: " + timeElapsed);
    }

    public static int[] generateRandomIntegerArray(int arraySize){
        int[] randomArray = new int[arraySize];
        for(int i = 0; i < arraySize; i++){
            randomArray[i] = (int)(Math.random() * 100);
        }
        return randomArray;
    }

}

