package com.edu.model.IngresDetail;

import com.edu.model.Ingress;
import com.edu.model.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
                                //transformar la estructura de un objetio A -> B
public class IngressDetailPK implements Serializable {


    @ManyToOne
    @JoinColumn(nullable = false , name = "id_ingress" , foreignKey = @ForeignKey(name = "FK_ID_INGRESS"))
    private Ingress ingress;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_product" , foreignKey = @ForeignKey(name = "FK_ID_PRODUCT"))
    private Product product;
}
