package com.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idProduct;


    //fk category
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false , foreignKey = @ForeignKey(name = "FK_PRODUCT_CATEGORY"))
    private Category category;

    @Column(nullable = false , length = 30)
    private String name;

    @Column(nullable = false ,length = 30 , columnDefinition = "decimal(6,2)") //9999.99
    private double price;

    @Column(nullable = false , length = 200)
    private String description;

    @Column(nullable = false)
    private boolean enabled;

    //constructor de solo 2 vistas name , descripcion
    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public Product(boolean enabled) {
        this.enabled = enabled;
    }
}
