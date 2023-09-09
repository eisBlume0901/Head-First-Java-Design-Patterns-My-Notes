package Part6SettingBehaviorsDynamically;
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

    // To change the duck's behavior at runtime,
    // just call the duck's setter method for that behavior

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
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

class ModelDuck extends Duck
{
    public ModelDuck()
    {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display()
    {
        System.out.println("I am a model duck");
    }
}
class MiniDuckSimulator
{
    public static void main(String[] args)
    {
        Duck mallard = new MallardDuck();
        mallard.performQuack(); // Quack
        mallard.performFly(); // I'm flying

        Duck model = new ModelDuck();
        model.performFly(); // use for debugging
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}