package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.repository.PurchaseRepository;
import fr.simplon.domedespuys.service.interfaces.IPurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements IPurchaseService {
    private PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getCollection() {
        return List.of();
    }

    @Override
    public Purchase create(PurchasePostDTO dto) {
        //Penser au CreatedAt, User, Status, Number

        return null;
    }

    @Override
    public Purchase getById(String id) {
        return null;
    }

    @Override
    public Purchase update(String id, PurchasePutDTO dto) {
        return null;
    }
}
