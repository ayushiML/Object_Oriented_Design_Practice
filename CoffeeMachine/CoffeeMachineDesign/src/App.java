public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Coffeefactory factory = new Coffeefactory();
         Coffee a = factory.create(CoffeeType.ESPRESSO);
         Coffee b = factory.create(CoffeeType.LATTE);
         Coffee c = factory.create(CoffeeType.CAPCINNO);
         System.out.println(a.brew());
         System.out.println(b.brew());
         System.out.println(c.brew());

    }
}
