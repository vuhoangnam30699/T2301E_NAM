package pom;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dependency {
    private String groupId;
    private String artifactId;
    private String version;
    private String scope;
}
