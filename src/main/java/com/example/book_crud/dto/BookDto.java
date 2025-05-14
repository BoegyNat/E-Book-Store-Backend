package com.example.book_crud.dto;


import jakarta.validation.constraints.*;

public class BookDto {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @Min(value = 0, message = "Price must be positive")
    private int price;

    @NotNull(message = "Year is required")
    @Min(value = 1500, message = "Year must be after 1500")
    private int year;

    private String description;

    @NotNull(message = "Image is required")
    private String coverUrl;

    @NotNull(message = "PDF is required")
    private String pdfPath;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCoverUrl() { return coverUrl; }
    public void setCoverUrl(String coverUrl) { this.coverUrl = coverUrl; }

    public String getPdfPath() { return pdfPath; }
    public void setPdfPath(String pdfPath) { this.pdfPath = pdfPath; }
}
