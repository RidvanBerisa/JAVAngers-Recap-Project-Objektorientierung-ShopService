import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.With;




public class ShopService {

    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();

    public Order addOrder(List<String> productIds) throws ProductNotFoundException {
        List<Product> products = new ArrayList<>();

        for (String productId : productIds) {
            Optional<Product> productToOrder = productRepo
                    .getProductById(productId);

                   Product product = productToOrder.orElseThrow(() -> new
                   ProductNotFoundException("Product with ID" + productId + "not found"));
                   products.add(product);
            }

            Instant orderTimestamp = Instant.now();

        Order newOrder = new Order(UUID.randomUUID().toString(), products, OrderStatus.PROCESSING);
        return orderRepo.addOrder(newOrder);
    }

    // private void orElseThrow(Object productNotFound) {
    //private void orElseThrow(Object notFound) {

    public List<Order> getOrderByStatus(OrderStatus status) {
        return orderRepo.getOrders().stream()
                .filter(order -> order.status().equals(status))
                .toList();
    }

    public Order updateStatus(String orderId, OrderStatus newStatus) {
        Order order = orderRepo.getOrderById(orderId);
        if (order != null) {
            Order updateOrder = order.withStatus(newStatus);

        return orderRepo.addOrder(updateOrder);
        }
        return null;
    }
}
