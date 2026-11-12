package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.repository.BrandRepository;
import fr.simplon.domedespuys.service.interfaces.IBrandService;
import fr.simplon.domedespuys.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements IBrandService {
    private BrandRepository brandRepository;
    private Slugger slugger;

    @Override
    public List<Brand> getCollection(){
        return brandRepository.findAll();
    }

    @Override
    public Brand create(BrandDTO dto){
        Brand brand = new Brand();
        dtoToObject(dto, brand);
        return brand;
    }

    @Override
    public Brand getById(String id) {
        return brandRepository.findById(Long.parseLong(id))
                .orElse(null);
    }

    @Override
    public Brand update(String id, BrandDTO dto) {
        Brand brand = getById(id);
        if (brand != null){
            dtoToObject(dto, brand);
        }
        return brand;
    }

    @Override
    public boolean delete(String id) {
         try{
             brandRepository.deleteById(Long.parseLong(id));
             return true;
         }catch(NumberFormatException e){
             System.out.println(e.getMessage());
        }
        return false;
    }

        private void dtoToObject(BrandDTO dto, Brand brand){
            brand.setLabel(dto.label);
            brand.setLogo(dto.logo);
            brand.setSlug(slugger.slugify(dto.label));
            brandRepository.saveAndFlush(brand);
        }
}
