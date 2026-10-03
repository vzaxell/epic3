package com.epic3.service;

import com.epic3.dto.ReviewRequest;
import com.epic3.model.Review;
import com.epic3.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Transactional
    public Review create(ReviewRequest request) {
        Review review = new Review(
                request.getTitle().trim(),
                request.getComment().trim(),
                request.getRating(),
                request.getAuthor().trim()
        );
        return reviewRepository.save(review);
    }

    @Transactional(readOnly = true)
    public List<Review> search(String title, String author) {
        boolean hasTitle = title != null && !title.isBlank();
        boolean hasAuthor = author != null && !author.isBlank();

        if (hasTitle && hasAuthor) {
            return reviewRepository
                    .findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCaseOrderByCreatedAtDesc(title.trim(), author.trim());
        }
        if (hasTitle) {
            return reviewRepository.findByTitleContainingIgnoreCaseOrderByCreatedAtDesc(title.trim());
        }
        if (hasAuthor) {
            return reviewRepository.findByAuthorContainingIgnoreCaseOrderByCreatedAtDesc(author.trim());
        }
        return reviewRepository.findAllByOrderByCreatedAtDesc();
    }
}
