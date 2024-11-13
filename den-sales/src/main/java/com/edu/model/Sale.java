package com.edu.model;


import com.edu.dto.prod.ProcedureSale1DTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@NamedNativeQuery(
        name = "Sale.fn_sales",
        query = "select * from fn_sales()",
        resultSetMapping = "Procedure.ProcedureDTO"
)
@SqlResultSetMapping(
    name = "Procedure.ProcedureDTO",
        classes = @ConstructorResult(targetClass = ProcedureSale1DTO.class,
        columns = {
            @ColumnResult(name = "quantityfn", type = Integer.class),
                @ColumnResult(name = "datetimefn", type = String.class)

        })
)

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
    private Date dateTime;

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
