package Part15PizzaProblemAbstractFactoryMethod;

import static java.lang.System.*;

abstract class Pizza {
    private String name;
    private Dough dough;
    private Sauce sauce;
    private Cheese cheese;
    private Veggies[] veggies;
    private Pepperoni pepperoni;
    private Clams clam;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public Veggies[] getVeggies() {
        return veggies;
    }

    public void setVeggies(Veggies[] veggies) {
        this.veggies = veggies;
    }

    public Pepperoni getPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(Pepperoni pepperoni) {
        this.pepperoni = pepperoni;
    }

    public Clams getClam() {
        return clam;
    }

    public void setClam(Clams clam) {
        this.clam = clam;
    }

    public abstract void prepare();

    public void bake() {
        out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        out.println("Place pizza in official PizzaStore box");
    }

    public void box() {
        out.println("Place pizza in official PizzaStore box");
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

class CheesePizza extends Pizza
{
    private PizzaIngredientFactory pizzaIngredientFactory;


    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory)
    {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }
    @Override
    public void prepare() {
        out.println("Preparing " + getName());
        setDough(pizzaIngredientFactory.createDough());
        setSauce(pizzaIngredientFactory.createSauce());
        setCheese(pizzaIngredientFactory.createCheese());
    }
}

class ClamPizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory)
    {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }
    @Override
    public void prepare() {
        out.println("Preparing " + getName());
        setDough(pizzaIngredientFactory.createDough());
        setSauce(pi);
    }
}
class Dough { }
class Sauce { }
class Cheese { }
class Veggies { }
class Pepperoni { }

class Clams { }
public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();
}

class ThinCrustDough extends Dough{ }
class MarinaraSauce extends Sauce{ }
class ReggianoCheese extends Cheese{ }
class Garlic extends Veggies{ }
class Onion extends Veggies{ }
class Mushroom extends Veggies{ }
class RedPepper extends Veggies{ }
class FreshClams extends Clams { }

class SlicedPepperoni extends Pepperoni { }

class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {
                new Garlic(),
                new Onion(),
                new Mushroom(),
                new RedPepper()
        };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}

class PlumTomatoSauce extends Sauce { }
class MozzarellaCheese extends Cheese { }
class BlackOlives extends Veggies { }
class Spinach extends Veggies { }
class EggPlant extends Veggies { }
class FrozenClams extends Clams { }
class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {
                new BlackOlives(),
                new Spinach(),
                new EggPlant()
        };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }

}