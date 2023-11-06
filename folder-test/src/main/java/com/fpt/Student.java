package com.fpt;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Student {
    @Getter
    private String name;
    @Getter
    private String school;
    @Getter
    private LocalDate dateOfBirth;
    private String password;

    private String getPassword() {
        return getPassword();
    }

    public Student(@NonNull String name, String school) {
        this.name = name;
        this.school = school;
    }
}
