package fr.simplon.domedespuys.controller;

import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductRestController {

    private final ProductRepository productRepository;

    @GetMapping
    private List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    private Optional<Product> getProductById(@PathVariable String id) {
        return productRepository.findById(Long.valueOf(id));
    }

}
