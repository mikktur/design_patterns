package iterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int previous = 0;
    private int next = 1;
    private int remaining;
    public FibonacciIterator(int n) {
        this.remaining = n;

    }

    public boolean hasNext() {
        return remaining > 0;
    }


    public Integer next() {
        int current = previous;
        int sum = previous + next;
        previous = next;
        next = sum;
        remaining--;
        return current;
    }



}
