package com.hulktore.model;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduct;

    private String name;

    private String photo;

    private String description;

    private double price;

    private Integer stock;


}
