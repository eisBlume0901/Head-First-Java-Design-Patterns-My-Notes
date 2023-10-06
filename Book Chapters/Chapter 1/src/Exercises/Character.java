package Exercises;

public abstract class Character {
    WeaponBehavior weapon;

    public abstract void fight();

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
}

class King extends Character
{
    public King()
    {
        weapon = new BowAndArrowBehavior();
    }
    @Override
    public void fight() {
        System.out.println("King fights with ");
    }
}

class Queen extends Character
{
    public Queen()
    {
        weapon = new KnifeBehavior();
    }
    @Override
    public void fight() {

    }
}

class Knight extends Character
{
    public Knight()
    {
        weapon = new SwordBehavior();
    }
    @Override
    public void fight() {

    }
}

class Troll extends Character
{
    public Troll()
    {
        weapon = new AxeBehavior();
    }
    @Override
    public void fight() {

    }
}