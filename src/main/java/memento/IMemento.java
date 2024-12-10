package memento;

import java.time.LocalTime;

public interface IMemento {
    LocalTime getSavedAt();
    int[] getOptions();
    boolean isSelected();
}
