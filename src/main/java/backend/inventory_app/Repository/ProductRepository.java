package backend.inventory_app.Repository;

import backend.inventory_app.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByCategory(String category);
    List<Product> findByCreatedBy(String createdBy);

}
