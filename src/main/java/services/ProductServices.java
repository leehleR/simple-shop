package services;

import model.Products;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
public class ProductServices {
    private final ProductRepository productRepository;

    ProductServices(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Products> getAllProducts(){
        return productRepository.findAll();
    }

    public Products createProduct(Products products){
        return productRepository.save(products);
    }

    public Products getProductById(Long productId){
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public Products updateProduct(Long productId, Products productDetails){
        Products product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        product.setName(productDetails.getName());
        product.setQuantity(productDetails.getQuantity());
        product.setUnitPrice(productDetails.getUnitPrice());

        return productRepository.save(product);

    }

    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }
}
