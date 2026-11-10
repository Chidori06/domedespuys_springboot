package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.entity.Image;
import fr.simplon.domedespuys.service.interfaces.IImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements IImageService {
    @Override
    public Image create(ImageDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
