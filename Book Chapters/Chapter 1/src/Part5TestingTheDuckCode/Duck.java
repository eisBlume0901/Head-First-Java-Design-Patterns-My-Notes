package Part5TestingTheDuckCode;

public abstract class Duck
{
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck()
    {

    }

    public void performQuack()
    {
        quackBehavior.quack();
    }

    public void swim()
    {
        System.out.println("All ducks float, even decoys!");
    }

    // an abstract method must be overridden
    public abstract void display();
    public void performFly()
    {
        flyBehavior.fly();
    }
}

class MallardDuck extends Duck
{
    public MallardDuck()
    {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display()
    {
        System.out.println("I am a real Mallard Duck");
    }
}

class MiniDuckSimulator
{
    public static void main(String[] args)
    {
        Duck mallard = new MallardDuck();
        mallard.performQuack(); // Quack
        mallard.performFly(); // I'm flying
    }
}