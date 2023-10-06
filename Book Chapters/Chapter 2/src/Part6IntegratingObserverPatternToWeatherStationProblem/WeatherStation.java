package Part6IntegratingObserverPatternToWeatherStationProblem;

public class WeatherStation
{
    public static void main(String[] args)
    {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData); // push-pull
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData); // push-pull
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData); // push-pull
        /*
        The reason why it cannot be

        weatherData.register(currentDisplay);
        weatherData.register(statisticsDisplay);
        weatherData.register(forecastDisplay);

        is because when we execute this method

        weatherData.notify();

        It will notify all observers rather than just the display requesting for the update. Pushing data itself
         */

//        System.out.println("UPDATE UPDATE UPDATE");
//        weatherData.registerObserver(currentDisplay);
//        weatherData.notifyObservers(); // forcing-push
//        System.out.println();

//        currentDisplay.update(80, 65, 30.4f); // poll methodn but not recommended
        // Check setMeasurement() method
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.2f);

        weatherData.removeObserver(forecastDisplay);
        weatherData.setMeasurements(62,90,28.1f);

    }
}
