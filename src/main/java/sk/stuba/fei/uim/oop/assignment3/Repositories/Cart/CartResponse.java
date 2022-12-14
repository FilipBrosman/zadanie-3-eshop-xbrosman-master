package sk.stuba.fei.uim.oop.assignment3.Repositories.Cart;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.Repositories.CartProduct.ShoppingItemResponse;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CartResponse {
    private Long id;
    private List<ShoppingItemResponse> shoppingList;
    private boolean payed;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.shoppingList = cart.getShoppingList().stream().map(ShoppingItemResponse::new).collect(Collectors.toList());
        this.payed = cart.isPayed();
    }
}
