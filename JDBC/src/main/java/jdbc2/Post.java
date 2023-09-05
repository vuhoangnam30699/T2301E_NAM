package jdbc2;

import lombok.*;

import java.time.ZonedDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Post {
    private Integer id;
    private Integer userId;
    private ZonedDateTime publishedAt;
    private String content;
}
