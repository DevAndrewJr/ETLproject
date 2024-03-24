package it.projects.SQLserverProject.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;



@Data
@Entity
@Table(name="product")
public class Product {

    @Id
    @Column(name="code")
    private String code;

    @Column(name="nameProduct")
    private String nameProduct;

    @Column(name="description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name="category_id")
    private int categoryId;

    @Column(name="brand_id")
    private int brandId;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="weight")
    private Double weight;

    @Column(name="dimensions")
    private String dimensions;

    @Column(name="status")
    private String status;

}
