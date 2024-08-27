package com.example.cloudinary.java_cloudinary.Controller;

import com.example.cloudinary.java_cloudinary.Models.Image;
import com.example.cloudinary.java_cloudinary.Services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImagesController {
  private final ImageService imageService;

  @GetMapping
  public ResponseEntity<List<Image>> getAllImages() {
    List<Image> images = imageService.getAllImages();
    return ResponseEntity.ok(images);
  }

  @PostMapping("/upload")
  public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
    Image savedImage = imageService.uploadImage(file);
    return ResponseEntity.ok(savedImage);
  }
}
