package Part6IntegratingObserverPatternToWeatherStationProblem;
import java.util.*;
public class WeatherData implements Subject
{
    // Weather Data breaks the Single Chain Responsibility Principle
    // because it has two jobs
    // Recommended that the Subject should be an Abstract (Template Method)
    // since we just repeated the methods itself and just added new variation
    private List<Observer> observers;
    // To hold the Observers and create it in the constructor
    // The WeatherData Subject/Observable has many observers
    // One to Many
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData()
    {
        observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }


    @Override
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update(temperature, humidity, pressure);
        // forcing to push updates
    }
    /* Instead of the Subject pushing these new values, the Observer can be notified
    and pull the values it needs instead use getter methods

    public void notifyObservers()
    {
        for (Observer observer: observers)
            observer.update();
    }

    // Getter Methods
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
     */
    public void measurementsChanged()
    {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

}
