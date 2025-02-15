package erwin.springbootwebapp.Entity.CategoryEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Types {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;
    @Column(nullable = false , unique = true)
    private String typeName;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;  // Foreign key reference to Categories
}


