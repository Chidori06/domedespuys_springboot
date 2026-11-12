package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.repository.ProductRepository;
import fr.simplon.domedespuys.service.interfaces.IBrandService;
import fr.simplon.domedespuys.service.interfaces.IImageService;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import fr.simplon.domedespuys.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {
    private ProductRepository productRepository;
    private Slugger slugger;
    private IBrandService brandService;
    private IImageService imageService;

    @Override
    public List<Product> getCollection() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductDTO dto) {
        Product product = new Product();
        dtoToObject(dto, product);
        productRepository.saveAndFlush(product);
        for(ImageDTO imageDTO : dto.images){
            imageService.create(imageDTO, product);
        }
        imageService.flush();
        return product;
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(Long.parseLong(id))
                .orElse(null);
    }

    @Override
    public Product update(String id, ProductDTO dto) {
        Product product = getById(id);
        if(product!= null){
            dtoToObject(dto, product);
        }
        return product;
    }

    private void dtoToObject(ProductDTO dto, Product product){
        product.setLabel(dto.label);
        product.setPrice(dto.price);
        product.setCreatedAt(LocalDateTime.now());
        product.setBrand(brandService.getById(dto.idBrand));
        product.setSlug(slugger.slugify(dto.label));
    }

}
