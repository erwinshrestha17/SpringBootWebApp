package erwin.springbootwebapp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ProductName;
    private String ProductDescription;
    private String ProductImage;
    private String ProductPrice;
    private String ProductCategory;
    private String ProductStatus;
    private String ProductType;
    private String ProductBrand;
    private String ProductSize;

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", ProductName='" + ProductName + '\'' +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", ProductImage='" + ProductImage + '\'' +
                ", ProductPrice='" + ProductPrice + '\'' +
                ", ProductCategory='" + ProductCategory + '\'' +
                ", ProductStatus='" + ProductStatus + '\'' +
                ", ProductType='" + ProductType + '\'' +
                ", ProductBrand='" + ProductBrand + '\'' +
                ", ProductSize='" + ProductSize + '\'' +
                '}';
    }
}
