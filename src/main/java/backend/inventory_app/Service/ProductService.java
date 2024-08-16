package backend.inventory_app.Service;

import backend.inventory_app.Model.Product;
import backend.inventory_app.Model.User;
import backend.inventory_app.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.SequencedCollection;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        Product newProduct = new Product(
                product.getCreatedBy(),
                product.getProductNumber(),
                product.getName(),
                product.getCategory(),
                new Date(),
                new Date(),
                product.getExpirationDate()
        );

        return productRepository.save(newProduct);
    }

    public Product updateProduct(String id, Product productDetails) {
        Optional<Product> productOpt = productRepository.findById(id);
        if(productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setProductNumber(productDetails.getProductNumber());
            product.setName(productDetails.getName());
            product.setCategory(productDetails.getCategory());
            product.setLastUpdated(new Date());
            product.setExpirationDate(productDetails.getExpirationDate());
            return productRepository.save(product);
        } else {
            throw new IllegalArgumentException(STR."Product not found with id: \{id}");
        }
    }

    public Product deleteProduct(String id) {
        Optional<Product> productOpt = productRepository.findById(id);
        if(productOpt.isPresent())   {
            Product product = productOpt.get();
            productRepository.delete(product);
            return product;
        } else {
            throw new IllegalArgumentException(STR."Product was not found with id: \{id}");
        }
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getProductsByCreator(String createdBy) {
        return productRepository.findByCreatedBy(createdBy);
    }
}
