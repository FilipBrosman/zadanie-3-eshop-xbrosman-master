package sk.stuba.fei.uim.oop.assignment3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Cart.CartRequest;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Cart.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.Services.Cart.ICartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CartResponse createCart() {
        return new CartResponse(this.cartService.createCart());
    }

    @GetMapping("/{id}")
    public CartResponse getCart(@PathVariable("id") Long id) {
        return new CartResponse(this.cartService.getCart(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") Long id) {
        this.cartService.deleteCart(id);
    }

    @PostMapping("/{id}/add")
    public CartResponse addProductToCart(@PathVariable("id") Long id, @RequestBody CartRequest requeset) {
        return new CartResponse(this.cartService.addToCart(id, requeset));
    }

    @GetMapping("/{id}/pay")
    public String payForCart(@PathVariable("id") Long id) {
        return this.cartService.payForCart(id);
    }

}
