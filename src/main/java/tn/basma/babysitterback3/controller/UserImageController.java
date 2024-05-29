package tn.basma.babysitterback3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.basma.babysitterback3.entites.User;
import tn.basma.babysitterback3.entites.Image;
import tn.basma.babysitterback3.repositories.UserImageRepository;
import tn.basma.babysitterback3.repositories.UserRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/api/v1/image")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserImageController {

    @Autowired
    UserImageRepository imageRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/upload/{idUser}")
    public ResponseEntity<String> uploadImage(@RequestParam("imageFile") MultipartFile file, @PathVariable Long idUser) {
        try {
            Optional<User> userOptional = userRepository.findById(idUser);
            if (userOptional.isPresent()) {
                User userEntity = userOptional.get();

                if (userEntity.getUserImage() != null) {
                    return ResponseEntity.badRequest().body("User already has an image");
                }


                Image img = new Image();
                img.setName(file.getOriginalFilename());
                img.setType(file.getContentType());
                img.setPicByte(file.getBytes());

                imageRepository.save(img);

                img.setUserEntity(userEntity);

                imageRepository.save(img);

                return ResponseEntity.ok("image ( " + img.getName()+" ) added to user with ID:"+img.getUserEntity().getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



//hthya code modifier mta3 el image eme lezem na3tih taoken bch yabda autorise

    @PutMapping("/update/{idUser}")
    public ResponseEntity<String> updateImage(@RequestParam("imageFile") MultipartFile file, @PathVariable Long idUser) {
        try {
            Optional<User> userOptional = userRepository.findById(idUser);
            if (userOptional.isPresent()) {
                User userEntity = userOptional.get();

                if (userEntity.getUserImage() == null) {
                    return ResponseEntity.badRequest().body("User does not have an image");
                }

                Image img = userEntity.getUserImage();
                img.setName(file.getOriginalFilename());
                img.setType(file.getContentType());
                img.setPicByte(file.getBytes());

                imageRepository.save(img);

                return ResponseEntity.ok("Image ( " + img.getName()+" ) updated for user with ID:"+img.getUserEntity().getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    //hthya methode mte3 suuprime image

    @DeleteMapping("/deleteImage/{idUser}")
    public ResponseEntity<String> deleteImage(@PathVariable Long idUser) {
        Optional<User> userOptional = userRepository.findById(idUser);
        if (userOptional.isPresent()) {
            User userEntity = userOptional.get();

            if (userEntity.getUserImage() == null) {
                return ResponseEntity.badRequest().body("User does not have an image");
            }

            Image img = userEntity.getUserImage();

            imageRepository.delete(img);

            return ResponseEntity.ok("Image deleted for user with ID:"+img.getUserEntity().getId());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    //mezelet affichage mta3 tswer


    @GetMapping("/get/{idUser}")
    public ResponseEntity<Image> getImageByidUser(@PathVariable Long idUser) {
        Optional<User> userOptional = userRepository.findById(idUser);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Image image = user.getUserImage();
            if (image != null) {
                return ResponseEntity.ok(image);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }













    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException | DataFormatException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
