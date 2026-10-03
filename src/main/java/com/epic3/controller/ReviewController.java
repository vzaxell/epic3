package com.epic3.controller;

import com.epic3.dto.ReviewRequest;
import com.epic3.model.Review;
import com.epic3.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Historia 1: publicar una reseña
    @PostMapping
    public ResponseEntity<Review> create(@Valid @RequestBody ReviewRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.create(request));
    }

    // Historia 2: consultar reseñas por título y/o autor (ambos opcionales)
    @GetMapping
    public List<Review> search(@RequestParam(required = false) String title,
                               @RequestParam(required = false) String author) {
        return reviewService.search(title, author);
    }
}
