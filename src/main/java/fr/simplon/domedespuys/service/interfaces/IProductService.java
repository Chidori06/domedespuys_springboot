package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entity.Product;

public interface IProductService extends
        ICollection<Product>,
        IGetItem<Product>,
        ICreate<Product, ProductDTO>,
        IUpdate<Product, ProductDTO>
{
}
