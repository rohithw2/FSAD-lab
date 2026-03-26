package com.example.demo;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository repo;

    public ProductController(ProductRepository repo){
        this.repo = repo;
    }

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category){
        return repo.findByCategory(category);
    }
}
