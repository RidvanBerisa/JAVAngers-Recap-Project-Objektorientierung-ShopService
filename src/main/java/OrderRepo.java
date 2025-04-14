import java.util.List;

public interface OrderRepo {

    List<Order> getOrders();

    List<Order> getAllOrders();

    Order getOrderById(String id);

    Order addOrder(Order newOrder);

    void removeOrder(String id);
}
