package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.PurchaseProductDTO;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.entity.PurchaseProduct;
import fr.simplon.domedespuys.repository.PurchaseProductRepository;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import fr.simplon.domedespuys.service.interfaces.IPurchaseProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseProductServiceImpl implements IPurchaseProductService {

    private final PurchaseProductRepository purchaseProductRepository;
    private final IProductService productService;

    @Override
    public PurchaseProduct create(Purchase purchase, PurchaseProductDTO purchaseProductDTO) {
        PurchaseProduct purchaseProduct = new PurchaseProduct();

        purchaseProduct.setQuantity(purchaseProductDTO.quantity);
        purchaseProduct.setPrice(purchaseProductDTO.price);
        purchaseProduct.setProduct(productService.getById(purchaseProductDTO.idProduct));
        purchaseProduct.setPurchase(purchase);

        purchaseProductRepository.saveAndFlush(purchaseProduct);
        return purchaseProduct;
    }
}
