package observer;

import observer.model.WeatherStation;
import observer.view.SomeKindOfObserver;

public class Main {

    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation();

        //en ollu ihan varma oliko tarkotus tehä monta eri observer classia, mutta aattelin että riittää jos parametrin kautta saa uniikin messagen.
        SomeKindOfObserver observer1 = new SomeKindOfObserver("Observer 1", weatherStation);
        SomeKindOfObserver observer2 = new SomeKindOfObserver("Observer 2", weatherStation);
        SomeKindOfObserver observer3 = new SomeKindOfObserver("Observer 3", weatherStation);


        weatherStation.start();
        //waits for 5 seconds and then stops the weather station.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherStation.stop();
        System.out.println("Removing observer 1");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherStation.removeObserver(observer1);
        weatherStation.start();


        //waits for 10 seconds and then stops the weather station.
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherStation.stop();
    }
}