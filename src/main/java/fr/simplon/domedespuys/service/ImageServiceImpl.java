package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.entity.Image;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.repository.ImageRepository;
import fr.simplon.domedespuys.service.interfaces.IImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements IImageService {

    private ImageRepository imageRepository;

    @Override
    public Image create(ImageDTO dto, Product product) {
        Image image = new Image();
        image.setProduct(product);
        image.setIsDefault(dto.isDefault);
        image.setPath(dto.path);
        image.setExtension("png");
        imageRepository.save(image);
        return image;
    }

    @Override
    public boolean delete(String id) {
        try{
            imageRepository.deleteById(Long.parseLong(id));
            return true;
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
