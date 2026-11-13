package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.service.interfaces.dao.ICreate;
import fr.simplon.domedespuys.service.interfaces.dao.IDelete;
import fr.simplon.domedespuys.service.interfaces.dao.IGetItem;
import fr.simplon.domedespuys.service.interfaces.dao.IUpdate;

public interface IUserService extends
        ICreate<User, UserPostDTO>,
        IUpdate<User, UserPutDTO>,
        IGetItem<User>,
        IDelete
{
}
