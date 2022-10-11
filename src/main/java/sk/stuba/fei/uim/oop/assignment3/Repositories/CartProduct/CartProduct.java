package sk.stuba.fei.uim.oop.assignment3.Repositories.CartProduct;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Cart.Cart;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Product.Product;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product products;

    @Setter
    private Integer cartAmount;

    public CartProduct(Cart cart, Product products, Integer amount) {
        this.cart = cart;
        this.products = products;
        this.cartAmount = amount;
    }

}
