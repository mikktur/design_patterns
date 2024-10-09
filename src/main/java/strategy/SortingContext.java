package strategy;

public class SortingContext {

    private SortingStrategy strategy;

    public SortingContext(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public int[] sort(int[] arr) {
        return strategy.sort(arr);
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }


}
