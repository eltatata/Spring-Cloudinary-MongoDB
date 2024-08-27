package com.example.cloudinary.java_cloudinary.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "images")
public class Image {
  @Id
  private String id;
  private String publicId;
  private String url;
  private String folder;
  private LocalDateTime createdAt;
}
