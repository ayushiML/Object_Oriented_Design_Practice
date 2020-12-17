package repository;

import java.util.List;

import model.Order;

public class OrderRepository {
    List<Order> orderList;
    private static  OrderRepository orderRepo;
    private OrderRepository(){}
    public static OrderRepository getInstance(){
        if(orderRepo == null){
            orderRepo = new OrderRepository();
        }
        return orderRepo;
    }
}
