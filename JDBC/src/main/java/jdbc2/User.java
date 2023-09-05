package jdbc2;

import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date dob;
}
