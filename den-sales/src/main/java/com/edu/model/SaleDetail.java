package com.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idSaleDetail;

    @ManyToOne
    @JoinColumn(name = "id_sale", nullable = false,foreignKey = @ForeignKey (name = "FK_DETAL_SALE"))
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false,foreignKey = @ForeignKey (name = "FK_DETAIL_PRODUCT"))
    private Product product;

    @Column(nullable = false)
    private short quantity;

    @Column(nullable = false, columnDefinition = "decimal(6,2)")
    private double salePrice;

    @Column(nullable = false, columnDefinition = "decimal(6,2)")
    private double discount;

}
