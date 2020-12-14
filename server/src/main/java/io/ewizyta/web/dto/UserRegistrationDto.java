package io.ewizyta.web.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationDto {
    private String imie;
    private String nazwisko;
    private String email;
    private String password;
    private String pesel;
    private String telefon;

    public String getUsername() {
        return getEmail();
    }
}
