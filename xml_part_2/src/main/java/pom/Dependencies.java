package pom;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.List;

@Data
public class Dependencies {
    @JsonProperty("dependency")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Dependency> dependencies;
}
