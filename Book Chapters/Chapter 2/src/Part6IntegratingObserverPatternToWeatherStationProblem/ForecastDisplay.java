package Part6IntegratingObserverPatternToWeatherStationProblem;

public class ForecastDisplay implements Observer, DisplayElement
{
    private float currentPressure = 29.92f;
    private float lastPressure;
    private WeatherData weatherData;
    // ForecastDisplay has a relationship with WeatherData

    public ForecastDisplay(WeatherData weatherData) // We are coupling this
    {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        // Means that it does not need to rely to the WeatherData

        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure)
            System.out.println("Improving weather on the way!");
        else if (currentPressure == lastPressure)
            System.out.println("More of the same");
        else if (currentPressure < lastPressure)
            System.out.println("Watch out for cooler, rainy weather");

    }
}
