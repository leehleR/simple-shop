package controller;


import model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ProductServices;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductServices productServices;

    @Autowired
    ProductController(ProductServices productServices){
        this.productServices = productServices;
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts(){
            List<Products> products = productServices.getAllProducts();

            return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Products> addProducts(@RequestBody Products products){
        Products products1 = productServices.createProduct(products);
        return ResponseEntity.ok(products1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long productId){
        Products productsById = productServices.getProductById(productId);
        return ResponseEntity.ok(productsById);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> updateProducts(@PathVariable Long productId, Products productsDetails){
        Products updateProduct = productServices.updateProduct(productId,productsDetails);

        return ResponseEntity.ok(updateProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> deleteProducts(@PathVariable Long productId){
         productServices.deleteProduct(productId);

         return ResponseEntity.noContent().build();
    }
}
