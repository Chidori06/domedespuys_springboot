package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.service.interfaces.dao.ICollection;
import fr.simplon.domedespuys.service.interfaces.dao.ICreate;
import fr.simplon.domedespuys.service.interfaces.dao.IGetItem;
import fr.simplon.domedespuys.service.interfaces.dao.IUpdate;

public interface IProductService extends
        ICollection<Product>,
        IGetItem<Product>,
        ICreate<Product, ProductDTO>,
        IUpdate<Product, ProductDTO>
{
}
