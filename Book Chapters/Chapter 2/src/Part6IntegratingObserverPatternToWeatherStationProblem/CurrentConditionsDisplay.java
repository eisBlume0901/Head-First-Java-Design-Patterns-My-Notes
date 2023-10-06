package Part6IntegratingObserverPatternToWeatherStationProblem;

public class CurrentConditionsDisplay implements Observer, DisplayElement
{
    private float temperature;
    private float humidity;
    private WeatherData weatherData; // Encapsulating Weather Data to reduce coupling
    // CurrentConditionsDisplay has a relationship with WeatherData

    public CurrentConditionsDisplay(WeatherData weatherData) // We are coupling them
    {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
        /*
        "this" = CurrentConditionsDisplay class

        Notice that the parameter of the weatherData.registerObserver(Observer o)
        is an interface; however, we passed in a class instead.

        Interface is inherently abstract which allows
        1. Contract
            - The CurrentConditionsDisplay class can use methods from the
            interface by forcing a contract with it to implement its sets
            of methods
        2. Polymorphism through Abstraction
            - Interface methods can be overridden by the class that has
            implemented it
            - the weatherData.registerObserver(Observer o) only accepts
            an interface parameter which is an Observer. Since the
            CurrentConditionsDisplay class implemented the Observer
            interface it is compatible with the method's expectation
            of an Observer. The Observer has taken another form which is
            CurrentConditionsDisplay (polymorphism)
                - Inside the registerObserver method, the weatherData object
                will store a reference to "this", which is an instance of
                CurrentConditionsDisplay; but, it is treated as an Observer
                - Interface-based polymorphism adheres to Liskov Substitution
                Principle (LSP)
         */
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
        // Means that it does not need to rely to the WeatherData
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: " + temperature +
                "F degrees " + humidity + "% humidity");
    }

}
