package com.example.cloudinary.java_cloudinary.Repositories;

import com.example.cloudinary.java_cloudinary.Models.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {
}
