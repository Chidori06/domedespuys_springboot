package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.repository.UserRepository;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    @Override
    public User create(UserPostDTO dto) {
        //Penser au CreatedAt
        User user = new User();
        user.setEmail(dto.email);
        user.setFirstname(dto.firstname);
        user.setLastname(dto.lastname);
        user.setPassword(dto.password);
        user.setCreatedAt(LocalDate.now().atStartOfDay());
        userRepository.saveAndFlush(user);
        return user;
    }
    @Override
    public User getById(String id) {
        return userRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public User update(String id, UserPutDTO dto) {
        return user;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }


}
