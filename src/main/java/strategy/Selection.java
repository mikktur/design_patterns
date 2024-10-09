package strategy;

import java.util.ArrayList;
import java.util.List;

public class Selection implements SortingStrategy {


    // copied from https://www.geeksforgeeks.org/selection-sort-algorithm-2/
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {

            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {

                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // If a new minimum is found,
            // swap it with the element at index i
            if (min_idx != i) {
                int temp = arr[i];
                arr[i] = arr[min_idx];
                arr[min_idx] = temp;
            }
        }
        List<Integer> sortedList = new ArrayList<>();
        for (int value : arr) {
            sortedList.add(value);
        }
        return arr;
    }
}
