package Exercises;

public interface WeaponBehavior
{
    public void useWeapon();
}

class KnifeBehavior implements WeaponBehavior
{
    @Override
    public void useWeapon() {
        System.out.println("Cutting with a knife");
    }
}

class BowAndArrowBehavior implements WeaponBehavior
{
    @Override
    public void useWeapon() {
        System.out.println("Shooting an arrow with a bow");
    }
}

class AxeBehavior implements WeaponBehavior
{
    @Override
    public void useWeapon() {
        System.out.println("Chopping with an axe");
    }
}

class SwordBehavior implements WeaponBehavior
{

    @Override
    public void useWeapon() {
        System.out.println("Swinging a sword");
    }
}