package erwin.springbootwebapp.Entity.CategoryEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(nullable = false)
    private int category_id;
    @Column(nullable = false, unique = true)
    private String categoryName;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Types> types;  // One Category can have many Types
}


