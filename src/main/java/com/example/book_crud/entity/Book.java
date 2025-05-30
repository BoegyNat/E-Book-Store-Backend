package com.example.book_crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "books")  // ชื่อตารางใน Oracle DB
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Oracle อาจไม่รองรับ ต้องใช้ SEQUENCE
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @Min(value = 0, message = "Price must be positive")
    private int price;

    @NotNull(message = "Year is required")
    @Min(value = 1500, message = "Year must be after 1500")
    private int year;

    @Column(length = 10000)
    private String description;

    @NotNull(message = "Image is required")
    private String coverUrl;

    @NotNull(message = "PDF is required")
    private String pdfPath;

    // --- Getter & Setter ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getCoverUrl() {return coverUrl;}
    public void setCoverUrl(String coverUrl) {this.coverUrl = coverUrl;}

    public String getPdfPath() {return pdfPath;}
    public void setPdfPath(String pdfPath) {this.pdfPath = pdfPath;}

}
