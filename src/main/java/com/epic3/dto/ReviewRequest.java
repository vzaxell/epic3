package com.epic3.dto;

import jakarta.validation.constraints.*;

public class ReviewRequest {

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 255, message = "El título no puede superar 255 caracteres")
    private String title;

    @NotBlank(message = "El comentario es obligatorio")
    @Size(max = 2000, message = "El comentario no puede superar 2000 caracteres")
    private String comment;

    @NotNull(message = "La puntuación es obligatoria")
    @Min(value = 1, message = "La puntuación mínima es 1")
    @Max(value = 5, message = "La puntuación máxima es 5")
    private Integer rating;

    @NotBlank(message = "El nombre del autor es obligatorio")
    @Size(max = 255, message = "El autor no puede superar 255 caracteres")
    private String author;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}
