package product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import product.Product;

import java.util.List;

public class Store {
    @JsonProperty("product")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Product> products;
}
