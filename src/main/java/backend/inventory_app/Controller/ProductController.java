package backend.inventory_app.Controller;

import backend.inventory_app.Model.Product;
import backend.inventory_app.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/category={category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/createdBy={createdBy}")
    public List<Product> getCreatedBy(@PathVariable String createdBy) {
        return productService.getProductsByCreator(createdBy);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }


    @PostMapping("/update/id={id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete/id={id}")
    public Product delete(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}

