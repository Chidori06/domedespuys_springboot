package fr.simplon.domedespuys.controller;

import fr.simplon.domedespuys.entity.PurchaseProduct;
import fr.simplon.domedespuys.repository.PurchaseProductRepository;
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
    public List<PurchaseProduct> getPurchaseProducts(){
        return purchaseProductRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PurchaseProduct> getPurchaseProductById(@PathVariable String id){
        return purchaseProductRepository.findById(Long.valueOf(id));
    }
}
