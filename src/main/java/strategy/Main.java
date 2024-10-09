package strategy;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] smallArray = generateRandomArray(30);
        int[] largeArray = generateRandomArray(100000);
        // Create a SortingContext with SelectionSort
        System.out.println("Testing Selection Sort");
        SortingContext context = new SortingContext(new Selection());
        System.out.println("Starting Small array Test");
        testPerf(context, smallArray.clone());
        System.out.println("Finished Small array Test");
        System.out.println("Starting Large array Test");
        testPerf(context, largeArray.clone());
        System.out.println("Finished Large array Test");


        System.out.println("Testing Bubble Sort");
        // Change to BubbleSort strategy
        context.setStrategy(new BubbleSort());
        System.out.println("Starting Small array Test");
        testPerf(context, smallArray.clone());
        System.out.println("Finished Small array Test");
        System.out.println("Starting Large array Test");
        testPerf(context, largeArray.clone());
        System.out.println("Finished Large array Test");


        System.out.println("Testing Insertion Sort");
        // Change to InsertionSort strategy
        context.setStrategy(new InsertionSort());
        System.out.println("Starting Small array Test");
        testPerf(context, smallArray.clone());
        System.out.println("Finished Small array Test");
        System.out.println("Starting Large array Test");
        testPerf(context, largeArray.clone());
        System.out.println("Finished Large array Test");
    }


    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000); // Random values from 0 to 9999
        }
        return array;
    }
    public static void testPerf(SortingContext context, int[] arr) {
        long startTime = System.nanoTime();
        context.sort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time taken: " + duration/1000000 + "ms");
    }
}
