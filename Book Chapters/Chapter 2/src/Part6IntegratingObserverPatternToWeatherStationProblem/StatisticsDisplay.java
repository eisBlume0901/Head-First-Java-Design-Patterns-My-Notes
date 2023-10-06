package Part6IntegratingObserverPatternToWeatherStationProblem;

public class StatisticsDisplay implements Observer, DisplayElement
{
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private WeatherData weatherData;
    // StatisticsDisplay has a relationship with WeatherData


    public StatisticsDisplay(WeatherData weatherData) // We are coupling
    {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
        // Means that it does not need to rely to the WeatherData

        tempSum += temperature;
        numReadings++;

        if (temperature > maxTemp) maxTemp = temperature;
        if (temperature < maxTemp) minTemp = temperature;

        display();
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " +
                (tempSum/numReadings) + "/" + maxTemp + "/" + minTemp);
    }
}
