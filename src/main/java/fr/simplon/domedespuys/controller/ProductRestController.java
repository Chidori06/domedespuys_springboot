package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import fr.simplon.domedespuys.view.ProductView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductRestController {

    private final IProductService productService;

    @GetMapping
    @JsonView(ProductView.ProductListView.class)
    public List<Product> getProducts() {
        return productService.getCollection();
    }


    @GetMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    public Product getProductById(@PathVariable String id) {
        return productService.getById(id);
    }

    @PostMapping
    @JsonView(ProductView.ProductDetailView.class)
    public Product createProduct(@RequestBody ProductDTO dto){
        return productService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    public Product updateProduct(@PathVariable String id, @RequestBody ProductDTO dto){
        return productService.update(id, dto);
    }

}
