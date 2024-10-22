package com.deen.model;


import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Product {

    private Integer id;
    private String name;
    private String description;
    private double price;
    private boolean status;

}
