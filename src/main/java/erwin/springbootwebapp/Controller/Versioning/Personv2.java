package erwin.springbootwebapp.Controller.Versioning;

import lombok.Getter;

@Getter
public class Personv2 {
    private final String firstName;
    private final String lastName;

    Personv2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
