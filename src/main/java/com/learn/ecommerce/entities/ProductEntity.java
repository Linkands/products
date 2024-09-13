package com.learn.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "Product name cant be empty")
    private String name;

    @Column
    @NotBlank(message = "Product description cant be empty")
    private String description;

    @Column
    @NotNull(message = "Product price cant be empty")
    private Double price;
}
