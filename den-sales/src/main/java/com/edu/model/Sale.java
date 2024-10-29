package com.edu.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idSale;


    //fk
    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false , foreignKey = @ForeignKey (name = "FK_SALE_CLIENT"))
    private Client client;

    //fk
    @ManyToOne
    @JoinColumn(name = "id_user" , nullable = false , foreignKey = @ForeignKey (name = "FK_SALE_USER"))
    private User user;


    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private double total;

    @Column(nullable = false,columnDefinition = "decimal(6,2)")
    private double tax;

    @Column(nullable = false)
    private boolean enabled;

    //maestro detalle
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleDetail> details;


}
