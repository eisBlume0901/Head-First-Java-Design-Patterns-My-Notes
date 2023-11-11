package Part15PizzaProblemAbstractFactoryMethod;

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