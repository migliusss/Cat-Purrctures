package com.example.catpurrctures;

/*
  This class is used to get a name of a random image from the "images" directory.
 */

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Random;

@Service
public class CatPurrcturesService {
    private final String catPicturesDirectory = "src/main/resources/static/images/";

    public String getRandomCatPicture() {
        // Create File object. Use it to create a directory of the images.
        File folder = new File(catPicturesDirectory);
        File[] files = folder.listFiles();

        // Check that the folder contains images.
        if (files != null && files.length > 0) {
            // Create a Random object. Generate a random index and get an image.
            Random random = new Random();
            File randomFile = files[random.nextInt(files.length)];

            return randomFile.getName();
        }
        return null;
    }
}
