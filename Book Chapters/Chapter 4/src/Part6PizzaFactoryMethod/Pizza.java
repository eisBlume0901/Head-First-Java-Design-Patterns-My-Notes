package Part6PizzaFactoryMethod;

import java.util.*;
import static java.lang.System.*;

public abstract class Pizza {
    private String name;
    private String dough;
    private String sauce;
    private List<String> toppings = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public void prepare()
    {
        out.println("Preparing " + name);
        out.println("Tossing " + dough);
        out.println("Adding " + sauce);
        out.println("Adding ");
        for (String topping : toppings)
            out.println(" " + topping);
    }

    public void bake()
    {
        out.println("Bake for 25 minutes at 350");
    }

    public void cut()
    {
        out.println("Cutting the pizza into diagonal slices");
    }

    public void box()
    {
        out.println("Place pizza in official PizzaStore box");
    }
}

class NYStyleCheesePizza extends Pizza
{
    public NYStyleCheesePizza() {
        setName("NY Style Sauce and Cheese Pizza");
        setDough("Thin Crust Dough");
        setSauce("Marinara Sauce");

        List<String> nyStyleCheesePizzaToppings = new ArrayList<>();
        nyStyleCheesePizzaToppings.add("Grated Reggiano Cheese");
        setToppings(nyStyleCheesePizzaToppings);
    }
}

class ChicagoStyleCheesePizza extends Pizza
{
    public ChicagoStyleCheesePizza() {
        setName("Chicago Style Deep Dish Cheese Pizza");
        setDough("Extra Thick Crust Dough");
        setSauce("Plum Tomato Sauce");

        List<String> chicagoStylePizzaTopppings = new ArrayList<>();
        chicagoStylePizzaTopppings.add("Shredded Mozzarella Cheese");
        setToppings(chicagoStylePizzaTopppings);
    }

    @Override
    public void cut() {
        out.println("Cutting the pizza into square slices");
    }
}

abstract class PizzaStore
{
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

class NYPizzaStore extends PizzaStore
{
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese"))
            return new NYStyleCheesePizza();
        else
            return null;
    }
}

class PizzaTestDrive {
    public static void main(String[] args)
    {
        PizzaStore nyStore = new NYPizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        out.println("Ethan ordered a " + pizza.getName() + "\n");
    }
}