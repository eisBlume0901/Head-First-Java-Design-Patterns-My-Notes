package Part6SettingBehaviorsDynamically;

public interface QuackBehavior
{
    public void quack();
}

class Quack implements QuackBehavior
{
    @Override
    public void quack()
    {
        System.out.println("Quack");
    }
}

class MuteQuack implements QuackBehavior
{
    @Override
    public void quack()
    {
        System.out.println("<< Silence >>");
    }
}


class Squeak implements QuackBehavior
{
    @Override
    public void quack()
    {
        System.out.println("Squeak");
    }
}