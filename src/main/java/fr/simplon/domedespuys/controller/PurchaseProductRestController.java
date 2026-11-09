package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entity.PurchaseProduct;
import fr.simplon.domedespuys.repository.PurchaseProductRepository;
import fr.simplon.domedespuys.view.PurchaseProductView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/purchaseProduct")
public class PurchaseProductRestController {

    public final PurchaseProductRepository purchaseProductRepository;

    @GetMapping
    @JsonView(PurchaseProductView.PurchaseProductListView.class)
    public List<PurchaseProduct> getPurchaseProducts(){
        return purchaseProductRepository.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(PurchaseProductView.PurchaseProductDetailView.class)
    public Optional<PurchaseProduct> getPurchaseProductById(@PathVariable String id){
        return purchaseProductRepository.findById(Long.valueOf(id));
    }
}
