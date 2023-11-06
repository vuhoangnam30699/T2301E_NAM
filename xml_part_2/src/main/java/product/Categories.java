package product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.List;

@Data
public class Categories {
    @JsonProperty("category")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Category> categories;
}
