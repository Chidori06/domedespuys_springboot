package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.repository.BrandRepository;
import fr.simplon.domedespuys.view.BrandView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brand")
public class BrandRestController {

    private final BrandRepository brandRepository;

    @GetMapping
    @JsonView(BrandView.BrandListView.class)
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }

    @GetMapping("/slug/{slug}")
    @JsonView(BrandView.BrandDetailView.class)
    public Optional<Brand> getBrandBySlug(@PathVariable String slug) {
        return brandRepository.findBySlug(slug);
    }

    @GetMapping("/{id}")
    @JsonView(BrandView.BrandDetailView.class)
    public Optional<Brand> getBrandById(@PathVariable String id) {
        return brandRepository.findById(Long.valueOf(id));
    }


}
