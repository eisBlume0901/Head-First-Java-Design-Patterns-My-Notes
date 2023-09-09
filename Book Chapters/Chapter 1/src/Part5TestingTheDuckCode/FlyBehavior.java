package Part5TestingTheDuckCode;

public interface FlyBehavior
{
    public void fly();
}

class FlyWithWings implements FlyBehavior
{
    @Override
    public void fly()
    {
        System.out.println("I am flying");
    }
}

class FlyNoWay implements FlyBehavior
{
    @Override
    public void fly()
    {
        System.out.println("I can't fly");
    }
}

class FlyRocketPowered implements FlyBehavior
{
    @Override
    public void fly()
    {
        System.out.println("I am flying with a rocket!");
    }
}
