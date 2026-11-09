package fr.simplon.domedespuys.controller;

import fr.simplon.domedespuys.entity.Image;
import fr.simplon.domedespuys.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/image")
public class ImageRestController {

    private final ImageRepository imageRepository;

    @GetMapping
    public List<Image> getImages(){
        return imageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Image> getImageById(@PathVariable String id){
        return imageRepository.findById(Long.valueOf(id));
    }

}
