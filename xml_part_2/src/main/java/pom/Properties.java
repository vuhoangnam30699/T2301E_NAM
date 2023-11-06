package pom;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Properties {
    @JsonProperty("maven.compiler.source")
    private Integer source;
    @JsonProperty("maven.compiler.target")
    private Integer target;
    @JsonProperty("project.build.sourceEncoding")
    private Integer sourceEncoding;
}
