package observer.view;

import observer.model.WeatherStation;

public class SomeKindOfObserver implements Observer {

    private final String name;
    private final WeatherStation weatherStation;
    private int temperature;
    public SomeKindOfObserver(String name, WeatherStation weatherStation) {
        this.name = name;
        this.weatherStation = weatherStation;
        weatherStation.addObserver(this);

    }

    @Override
    public void update() {
        this.temperature = weatherStation.getTemperature();
        System.out.println(name + " : " + temperature + "°C");
    }

}

