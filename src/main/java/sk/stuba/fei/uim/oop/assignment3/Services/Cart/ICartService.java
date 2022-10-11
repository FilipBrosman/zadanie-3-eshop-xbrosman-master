package sk.stuba.fei.uim.oop.assignment3.Services.Cart;

import sk.stuba.fei.uim.oop.assignment3.Repositories.Cart.Cart;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Cart.CartRequest;

public interface ICartService {
    Cart createCart();

    Cart getCart(Long id);

    void deleteCart(Long id);

    Cart addToCart(Long id, CartRequest request);

    String payForCart(Long id);
}
