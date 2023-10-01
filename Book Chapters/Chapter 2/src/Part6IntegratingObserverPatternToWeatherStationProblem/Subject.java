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
}

interface DisplayElement
{
    public void display();
}