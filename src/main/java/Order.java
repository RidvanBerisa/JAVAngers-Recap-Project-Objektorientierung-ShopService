import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;
import java.util.List;
import java.time.Instant;

@Value
@AllArgsConstructor
@With
public class Order{
        String id;
        List<Product> products;
        OrderStatus status;
        Instant orderTimestamp;

        public Object status() {
            return null;
        }
}
