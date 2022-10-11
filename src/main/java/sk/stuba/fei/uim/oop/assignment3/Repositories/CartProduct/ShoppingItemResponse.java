package sk.stuba.fei.uim.oop.assignment3.Repositories.CartProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.Repositories.CartProduct.CartProduct;

@Getter
@Setter
@AllArgsConstructor
public class ShoppingItemResponse {
    private Long productId;
    private Integer amount;

    public ShoppingItemResponse(CartProduct cartProduct) {
        this.productId = cartProduct.getProducts().getId();
        this.amount = cartProduct.getCartAmount();
    }
}
