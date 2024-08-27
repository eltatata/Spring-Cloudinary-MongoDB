package com.example.cloudinary.java_cloudinary.Services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.cloudinary.java_cloudinary.Config.CloudinaryConfig;
import com.example.cloudinary.java_cloudinary.Models.Image;
import com.example.cloudinary.java_cloudinary.Repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ImageService {
  private final Cloudinary cloudinary;
  private final CloudinaryConfig cloudinaryConfig;
  private final ImageRepository imageRepository;

  public List<Image> getAllImages() {
    return imageRepository.findAll();
  }

  public Image uploadImage(MultipartFile file) throws IOException {
    Map<String, Object> params = ObjectUtils.asMap(
            "folder", cloudinaryConfig.getFolder()
    );

    Map uploadResult = cloudinary.uploader().upload(file.getBytes(), params);

    Image image = new Image();
    image.setPublicId((String) uploadResult.get("public_id"));
    image.setUrl((String) uploadResult.get("url"));
    image.setFolder(cloudinaryConfig.getFolder());
    image.setCreatedAt(LocalDateTime.now());

    return imageRepository.save(image);
  }
}
