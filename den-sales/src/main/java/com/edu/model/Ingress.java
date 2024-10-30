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

public class Ingress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idIngres;

    @ManyToOne
    @JoinColumn(nullable = false , name = "id_provider", foreignKey = @ForeignKey(name = "FK_INGRESS_PROVIDER"))
    private Provider provider;

    @ManyToOne
    @JoinColumn(nullable = false , name = "id_user", foreignKey = @ForeignKey(name = "FK_INGRESS_USER"))
    private User user;

    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private double total;

    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private double tax;


}
