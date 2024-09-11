package observer.model;

import observer.view.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observeable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    //käy kaikki observerit läpi ja päivittää niiden tiedot.
    protected void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}