package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.service.interfaces.IUserService;

public class UserServiceImpl implements IUserService {

    @Override
    public User create(UserPostDTO dto) {
        //Penser au CreatedAt
        return null;
    }
    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public User update(String id, UserPutDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }


}
