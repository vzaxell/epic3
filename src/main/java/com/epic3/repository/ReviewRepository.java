package com.epic3.repository;

import com.epic3.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByTitleContainingIgnoreCaseOrderByCreatedAtDesc(String title);

    List<Review> findByAuthorContainingIgnoreCaseOrderByCreatedAtDesc(String author);

    List<Review> findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCaseOrderByCreatedAtDesc(String title, String author);

    List<Review> findAllByOrderByCreatedAtDesc();
}
