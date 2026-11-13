package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.repository.UserRepository;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    @Override
    public User create(UserPostDTO dto) {
        User user = new User();
        user.setEmail(dto.email);
        user.setFirstname(dto.firstname);
        user.setLastname(dto.lastname);
        user.setPassword(dto.password);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.saveAndFlush(user);
        return user;
    }
    @Override
    public User getById(String id) {
        return userRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public User update(String id, UserPutDTO dto) {
        User user = getById(id);
        if(user != null){
            dtoToObject(dto, user);
        }
        return user;
    }

    @Override
    public boolean delete(String id) {
        User user = getById(id);

        if (user != null) {
            user.setEmail("anonyme_" + user.getId() + "@deleted.fr");
            user.setFirstname("Anonyme");
            user.setLastname("Anonyme");
            user.setPassword(" ");
            user.setPhone(null);

            userRepository.saveAndFlush(user);
            return true;
        }
        return false;
    }

    private void dtoToObject(UserPutDTO dto, User user){
        user.setLastname(dto.lastname);
        user.setFirstname(dto.firstname);
        user.setPhone(dto.phone);
        userRepository.saveAndFlush(user);
    }

}
