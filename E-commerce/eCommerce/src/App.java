import service.OrderService;
import service.StoreService;
import service.UserService;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        UserService userService = new UserService();
        //userService.addUser(user);

        StoreService storeService = new StoreService();
        //storeService.getRecommendedProduct();

        OrderService orderService = new OrderService();
        //orderService.addOrder(order);

        userService.getUser(uid)
    }


}
