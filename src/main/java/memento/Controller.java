package memento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoHistory; // Redo history
    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        redoHistory.clear();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        redoHistory.clear();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            IMemento currentState = model.createMemento();
            redoHistory.add(currentState);
            IMemento previousState = history.remove(history.size() - 1);

            handleStateChange(previousState);
        }
    }
    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Memento found in redo history");
            IMemento currentState = model.createMemento();
            history.add(currentState);
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            handleStateChange(nextState);
        }
    }

    public List<IMemento> getHistory() {
        return Collections.unmodifiableList(history);
    }
    public void handleStateChange(IMemento memento) {
        model.restoreState(memento);
        gui.updateGui();
    }
    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }
}
