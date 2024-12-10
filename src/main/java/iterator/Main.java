package iterator;

import java.util.Iterator;

public class Main {
    // en alkanut muuttamaan bigintegeriin.
    public static void main(String[] args) {
        Iterator<Integer> iterator = new FibonacciSequence(15).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }
}
