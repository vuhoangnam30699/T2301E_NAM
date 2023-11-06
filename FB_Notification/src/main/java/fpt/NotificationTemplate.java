package fpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotificationTemplate {
    private Long id;
    private String content;
    private String language;
    private String code;
}
