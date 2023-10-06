package Part6IntegratingObserverPatternToWeatherStationProblem;
// Template for Observer Pattern
public interface Subject
{
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(); // is called to notify all observers
    // when the Subject's state has changed

}

interface Observer
{
    // temp, humidity, pressure are the state values the Observers
    // get from the Subject when a weather measurement changes
    public void update(float temperature, float humidity, float pressure);

    /* Instead of forcing to push the new values for temperature, humidity, and pressure
    to the observers, we can just notify the Observers that there is
    an update

    public void update();
     */
}

interface DisplayElement
{
    public void display();
}