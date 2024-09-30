package com.example.catpurrctures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class CatPurrcturesController {

    @Autowired
    private CatPurrcturesService catPurrcturesService;

    @GetMapping("/cat")
    public ResponseEntity<Resource> getRandomCatPicture() throws MalformedURLException {
        String randomCatPicture = catPurrcturesService.getRandomCatPicture();

        if (randomCatPicture != null) {
            Path file = Paths.get("src/main/resources/static/images").resolve(randomCatPicture);
            Resource resource = new UrlResource(file.toUri());

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + randomCatPicture + "\"")
                    .body(resource);
        }
        return ResponseEntity.notFound().build();
    }
}
