package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import fr.simplon.domedespuys.view.UserView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private final IUserService userService;

    @GetMapping("/{id}")
    @JsonView(UserView.UserDetailView.class)
    public User getUserById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PostMapping
    @JsonView(UserView.UserDetailView.class)
    public User createUser(@RequestBody UserPostDTO dto){
        return userService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(UserView.UserDetailView.class)
    public User updateUser(@PathVariable String id, @RequestBody UserPutDTO dto){
        return userService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    @JsonView(UserView.UserDetailView.class)
    public boolean deleteUser(@PathVariable String id){
        return userService.delete(id);
    }


}