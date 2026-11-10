package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.entity.Image;

public interface IImageService extends
        ICreate<Image, ImageDTO>,
        IDelete
{
}
