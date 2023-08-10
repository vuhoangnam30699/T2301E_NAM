package store;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {
    private String name;
    private Double price;
    private String sku;

    public Product(String name, Double price, String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }
}
