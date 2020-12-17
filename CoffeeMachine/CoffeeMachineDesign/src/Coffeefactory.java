public class Coffeefactory {
    //responsible to create object on the basics of input of choice

    public Coffee create(CoffeeType c)
    {   if(c.equals(CoffeeType.CAPCINNO))
        return new Capicino();
        else if(c.equals(CoffeeType.ESPRESSO))
        return new Espresso();
        else if(c.equals(CoffeeType.LATTE))
        return new Latte();
        else
        throw  new IllegalArgumentException
        (
            "Wrong coffee type: " + c
        );



    }
}
