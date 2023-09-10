package users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Order {
    private Integer id;
    private Integer userId;
    private String product;
    private Integer quantity;
}
