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
        out.println("Cut pizza");
    }

    public void box() {
        out.println("Place pizza in official PizzaStore box");
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

class CheesePizza extends Pizza // This Cheese Pizza will be subclassed by each regional US franchise
{
    private PizzaIngredientFactory pizzaIngredientFactory;


    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory)
    {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }
    @Override
    public void prepare() {
        out.println("Preparing " + getName());
        out.println("Ingredients to be used: ");
        setDough(pizzaIngredientFactory.createDough());
        out.println(getDough().toString());
        /*
        Pizza code uses the factory it has been composed with to produce
        the ingredients used in the pizza. The ingredients depend on which factory
        we are using. Pizza class does not care; it knows how to make pizzas.
         */
        setSauce(pizzaIngredientFactory.createSauce());
        out.println(getSauce().toString());
        setCheese(pizzaIngredientFactory.createCheese());
        out.println(getCheese().toString());
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
        setSauce(pizzaIngredientFactory.createSauce());
        setCheese(pizzaIngredientFactory.createCheese());
        setClam(pizzaIngredientFactory.createClam());
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

class ThinCrustDough extends Dough{

    private String name;

    public ThinCrustDough() {
        name = "Thin Crust Dough";
    }

    @Override
    public String toString() {
        return name;
    }
}
class MarinaraSauce extends Sauce{
    private String name;

    public MarinaraSauce()
    {
        name = "Marinara Sauce";
    }

    @Override
    public String toString() {
        return name;
    }
}
class ReggianoCheese extends Cheese{

    private String name;

    public ReggianoCheese()
    {
        name = "Reggiano Cheese";
    }

    @Override
    public String toString() {
        return name;
    }
}
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

abstract class PizzaStore {

    protected abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type)
    {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}

class NYPizzastore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory =
                new NYPizzaIngredientFactory();

        if (type.equals("cheese"))
        {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        }
        else if (type.equals("clam"))
        {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        }
        return pizza;
    }

    @Override
    public Pizza orderPizza(String type) {
        return super.orderPizza(type);
    }
}

class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();

        if (type.equals("cheese"))
        {
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        }
        else if (type.equals("clam"))
        {
            pizza = new ClamPizza(pizzaIngredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
        }
        return pizza;
    }

    @Override
    public Pizza orderPizza(String type) {
        return super.orderPizza(type);
    }
}

class PizzaTestDrive {

    public static void main(String[] args)
    {
        PizzaStore nyStore = new NYPizzastore();
        Pizza nyCheesePizza = nyStore.orderPizza("cheese");
    }
}