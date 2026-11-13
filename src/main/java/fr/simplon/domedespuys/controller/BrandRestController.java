package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.service.interfaces.IBrandService;
import fr.simplon.domedespuys.view.BrandView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brand")
public class BrandRestController {

  private final IBrandService brandService;

    @GetMapping
    @JsonView(BrandView.BrandListView.class)
    public List<Brand> getBrands() {
        return brandService.getCollection();
    }

    @GetMapping("/{id}")
    @JsonView(BrandView.BrandDetailView.class)
    public Brand getBrandById(@PathVariable String id) {
        return brandService.getById(id);
    }

    @PostMapping
    @JsonView(BrandView.BrandDetailView.class)
    public Brand createBrand(@Valid @RequestBody BrandDTO dto) {
        return brandService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(BrandView.BrandDetailView.class)
    public Brand updateBrand(@PathVariable String id, @Valid @RequestBody BrandDTO dto) {
      return brandService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    @JsonView(BrandView.BrandDetailView.class)
    public boolean deleteBrand(@PathVariable String id) {
    return brandService.delete(id);
  }

}
