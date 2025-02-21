package org.nt_uni.web_studio.model.dto.input;

import lombok.Data;

@Data
public class UserInput {
    private String username;
    private String firstname;
    private String lastname;
    private String surname;
    private String email;
    private String phoneNumber;
}
