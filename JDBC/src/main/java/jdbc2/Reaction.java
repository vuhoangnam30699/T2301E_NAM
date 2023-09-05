package jdbc2;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reaction {
    private Integer id;
    private Integer postId;
    private Integer userId;
    private Type type;
}
