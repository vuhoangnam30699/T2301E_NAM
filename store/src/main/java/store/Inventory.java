package store;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Inventory {
    private String sku;
    private Integer quantity;
    private String storeCode;

    public Inventory(String sku, int quantity, String storeCode) {
        this.sku = sku;
        this.quantity = quantity;
        this.storeCode = storeCode;
    }
}

