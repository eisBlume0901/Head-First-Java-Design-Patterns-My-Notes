package Part7ApplyingDecoratorPatternToBeverageProblem;

import static java.lang.System.*;

/* Observation: The declaration of behavior type is the same with the Strategy Pattern.
Look at the Duck class.

Decorators - Condiment Decorator uses inheritance to achieve type matching.
We are still using the OOP principle of favoring composition over inheritance
by subclassing the abstract class Beverage in order to have the correct
type, not to inherit its behavior. The behavior comes in through the composition
of decorators with the base components as well as other decorators
 */
public abstract class Beverage
{
    public enum Size
    {
        TALL, GRANDE, VENTI;
    }

    Size size = Size.TALL;
    String description = "Unknown beverage";
    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public abstract double cost();
}
/*
Condiment Decorator
 */
abstract class CondimentDecorator extends Beverage
{
    Beverage beverage;
    public abstract String getDescription();

    @Override
    public Size getSize()
    {
        return beverage.getSize();
    }
}

class Espresso extends Beverage
{
    public Espresso()
    {
        description = "Espresso";
        /* The instance variable, description, we declared in the Beverage
        class is initialize to its subclass constructor */
    }
    @Override
    public double cost() {
        return 1.99; // set the appropriate cost of Espresso
    }
}

class HouseBlend extends Beverage
{
    public HouseBlend()
    {
        description = "House Blend";
        /* The instance variable, description, we declared in the Beverage
        class is initialize to its subclass constructor */
    }
    @Override
    public double cost() {
        return 0.89; // set the appropriate cost of House Blend
    }
}

class DarkRoast extends Beverage
{
    public DarkRoast()
    {
        description = "Dark Roast";
    }

    @Override
    public double cost()
    {
        return 0.99;
    }
}
class Mocha extends CondimentDecorator
{
    /* The wrapping happens when we wrapped the Beverage to the
    decorator's constructor, Mocha.
     */
    public Mocha(Beverage beverage)
    {
        this.beverage = beverage;
        /* The instance variable, beverage, we declared in the Condiment
        Decorator is initialized to its subclass constructor. It is not
        the same with the description. It is only beverage since we are
        going to decorate or add it with other condiments.
         */
    }

    @Override
    public String getDescription() {
        // We added a new description to our based beverage
        return beverage.getDescription() + ", Mocha" ;
    }

    @Override
    public double cost() {
        // We need to compute the cost of the beverage with Mocha.
        return beverage.cost() + 0.20;
    }
}

class Soy extends CondimentDecorator
{
    public Soy(Beverage beverage)
    {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15;
    }
}

class Whip extends CondimentDecorator
{
    public Whip(Beverage beverage)
    {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();

        if (beverage.getSize() == Size.TALL)
            cost += 0.10;
        else if (beverage.getSize() == Size.GRANDE)
            cost += 0.15;
        else if (beverage.getSize() == Size.VENTI)
            cost += 0.20;
        return cost;
    }

}

class StarbucksCoffee {

    public static void main(String[] args)
    {
        // Order up an espresso, no condiments yet
        Beverage espresso = new Espresso();
        out.println(espresso.getDescription() + " $" + espresso.cost());
        // Espresso $1.99

        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast); // This is where the wrapping happens
        darkRoast = new Mocha(darkRoast); // However, this is outermost decorator
        darkRoast = new Whip(darkRoast);
        /* The reason each class use the
        beverage.cost() + condimentCost
        is because we can wrap them as much as we can.

        If we hard code the condiment price, we have to create
        a new class or alter the code always which is not good
        in the long run.
         */

        out.println(darkRoast.getDescription() + " $" + darkRoast.cost());
        // Dark Roast, Mocha, Mocha, Whip $1.49
        /*
        Instead of printing Dark Roast, Mocha, Mocha Whip
        It could be Dark Roast, Double Mocha, Whip
         */

        Beverage houseBlend = new HouseBlend();
        houseBlend.setSize(Beverage.Size.VENTI);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Soy(houseBlend);
        houseBlend = new Whip(houseBlend);

        out.println(houseBlend.getDescription() + " $" + houseBlend.cost());
        // House Blend, Mocha, Mocha, Soy, Whip $1.64
    }
}