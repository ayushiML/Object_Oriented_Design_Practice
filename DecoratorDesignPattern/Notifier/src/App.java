public class App {
    public static void main(String[] args) throws Exception {
        //https://refactoring.guru/design-patterns/decorator/java/example
        System.out.println("Hello, World!");
      //  String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                                         new EncryptionDecorator(
                                             new FileDataSource("out/OutputDemo.txt")));

         encoded.writeData(salaryRecords); 
         DataSource plain = new FileDataSource("out/OutputDemo.txt");
         System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
