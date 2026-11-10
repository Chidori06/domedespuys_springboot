package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.entity.User;

public interface IUserService extends
        ICreate<User, UserPostDTO>,
        IUpdate<User, UserPutDTO>,
        IGetItem<User>,
        IDelete
{
}
