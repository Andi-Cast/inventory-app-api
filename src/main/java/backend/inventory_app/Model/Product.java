package backend.inventory_app.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("Products")
public class Product {
    @Id
    private String id;
    private String createdBy;
    private Integer productNumber;
    private String name;
    private String category;
    private Date createdDate;
    private Date lastUpdated;
    private Date expirationDate;

    public Product(String createdBy,
                   Integer productNumber,
                   String name,
                   String category,
                   Date createdDate,
                   Date lastUpdated,
                   Date expirationDate) {
        this.id = UUID.randomUUID().toString();
        this.createdBy = createdBy;
        this.productNumber = productNumber;
        this.name = name;
        this.category = category;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
        this.expirationDate = expirationDate;
    }

}

