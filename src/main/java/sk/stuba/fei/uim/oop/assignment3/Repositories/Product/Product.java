package sk.stuba.fei.uim.oop.assignment3.Repositories.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.Repositories.CartProduct.CartProduct;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Integer amount;
    private String unit;
    private double price;

    @OneToMany
    private List<CartProduct> products = new ArrayList<>();

}
