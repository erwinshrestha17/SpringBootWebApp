package erwin.springbootwebapp.Controller.Versioning;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Personv1 {
    private String name;

    public Personv1(String name) {
        this.name = name;
    }
}
