package pom;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import pom.Dependencies;

import java.util.Properties;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    private String modelVersion;
    private String groupId;
    private String artifactId;
    private String version;
    private Properties properties;
    private Dependencies dependencies;
}
