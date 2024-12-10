package memento;

import java.time.LocalTime;


public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private LocalTime savedAt;
    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.savedAt = LocalTime.now();
        System.out.println("Memento created");
    }
    public LocalTime getSavedAt() {
        return savedAt;
    }
    public int[] getOptions() {
        return options.clone(); // Return a copy of options array
    }

    public boolean isSelected() {
        return isSelected;
    }

}
