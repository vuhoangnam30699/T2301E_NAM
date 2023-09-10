package http;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Post {
    private Integer id;
    
    @JsonAlias({"title", "name"})
    private String title;
    private String body;

    @JsonProperty("user_id")
    private Integer userId;
    private ArrayList<String> tags;
    private Integer reactions;
}
