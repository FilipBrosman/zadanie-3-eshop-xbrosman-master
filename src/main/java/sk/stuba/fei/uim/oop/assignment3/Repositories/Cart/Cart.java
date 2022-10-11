package sk.stuba.fei.uim.oop.assignment3.Repositories.Cart;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.Repositories.CartProduct.CartProduct;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean payed = false;

    @OneToMany
    private List<CartProduct> shoppingList = new ArrayList<>();
}
