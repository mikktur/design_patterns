package observer.model;


//sama kuin examplen userdata, mutta userinteractionin sijaan päivitys tapahtuu tietyin aikavälein.
public class WeatherStation extends Observeable implements Runnable {
    private int temperature;
    private boolean running = false;


    public WeatherStation() {
        this.temperature = generateRandomTemperature();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void run() {
        //test että initial temperature määrittyy oikein observereille voisi
        System.out.println("Weather station started");
        System.out.println("Initial temperature: " + temperature + "°C");
        notifyObservers();

        //looppaa "ikuisesti" ja päivittää lämpötilan 2s välein, voisi laittaa checking että jos lämpötila
        //ei muutu niin ei tarviis turhaan päivittää.
        while (running) {

            int newTemperature = generateRandomTemperature();
            setTemperature(newTemperature);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void start() {
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
    }

    private int generateRandomTemperature() {
        return (int) (-20 + Math.random() * 50); //pitäisi olla (-20) - +30c
    }
}