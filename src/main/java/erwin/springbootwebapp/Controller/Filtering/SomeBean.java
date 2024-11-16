package erwin.springbootwebapp.Controller.Filtering;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties("field3")
public class SomeBean {
    public SomeBean( String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    private String field1;
    @JsonIgnore
    private String field2;
    private String field3;




}
