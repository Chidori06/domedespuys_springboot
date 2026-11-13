package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchaseProductDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import fr.simplon.domedespuys.entity.EnumPurchaseStatus;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.entity.PurchaseProduct;
import fr.simplon.domedespuys.repository.AddressRepository;
import fr.simplon.domedespuys.repository.PurchaseRepository;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.service.interfaces.IPurchaseProductService;
import fr.simplon.domedespuys.service.interfaces.IPurchaseService;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements IPurchaseService {

    private PurchaseRepository purchaseRepository;

    private final IUserService userService;
    public final IAddressService addressService;
    private final IPurchaseProductService purchaseProductService;


    @Override
    public List<Purchase> getCollection() {
        return purchaseRepository.findAll();
    }

    @Override
    @Transactional
    public Purchase create(PurchasePostDTO dto) {
        Purchase purchase = new Purchase();
        purchase.setCreatedAt(LocalDateTime.now());
        purchase.setStatus(EnumPurchaseStatus.PENDING.getValue());
        purchase.setUser(userService.getById("8"));
        purchase.setAddress(addressService.getById(dto.idAddress));
        String number = "PUR-" + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-ddHHmm"));
        purchase.setNumber(number);
        purchaseRepository.saveAndFlush(purchase);
        List<PurchaseProduct> orderProducts = new ArrayList<>();
        for (PurchaseProductDTO dtoProduct : dto.orderProducts) {
            PurchaseProduct purchaseProduct = purchaseProductService.create(purchase, dtoProduct);

            orderProducts.add(purchaseProduct);
        }
        purchase.setOrderProduct(orderProducts);

        purchaseRepository.saveAndFlush(purchase);
        return purchase;
    }

    @Override
    public Purchase getById(String id) {
        return purchaseRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public Purchase update(String id, PurchasePutDTO dto) {
        Purchase purchase = getById(id);
        if (purchase != null) {
            purchase.setStatus(dto.Status);
            purchaseRepository.saveAndFlush(purchase);
        }
        return purchase;
    }
}
