package iterator;

import java.util.Iterator;

public class FibonacciSequence implements Sequence {
    private int n;

    public FibonacciSequence(int n) {
        this.n = n;

    }

    public Iterator<Integer> iterator() {
        return new FibonacciIterator(n);
    }


}
