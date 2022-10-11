package sk.stuba.fei.uim.oop.assignment3.Services.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sk.stuba.fei.uim.oop.assignment3.Exceptions.BadRequestException;
import sk.stuba.fei.uim.oop.assignment3.Exceptions.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Cart.Cart;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Cart.CartRequest;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Cart.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.Repositories.CartProduct.CartProduct;
import sk.stuba.fei.uim.oop.assignment3.Repositories.CartProduct.ICartProductRepository;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Product.Product;
import sk.stuba.fei.uim.oop.assignment3.Services.Product.IProductService;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ICartProductRepository cartProductRepository;

    @Autowired
    private IProductService productService;

    @Override
    public Cart createCart() {
        Cart newCart = new Cart();
        return this.cartRepository.save(newCart);
    }

    @Override
    @ExceptionHandler({NotFoundException.class})
    public Cart getCart(Long id) {
        Optional<Cart> oC = this.cartRepository.findById(id);
        return oC.orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteCart(Long id) {
        Optional<Cart> oC = this.cartRepository.findById(id);
        this.cartRepository.delete(oC.orElseThrow(NotFoundException::new));
    }

    @Override
    @ExceptionHandler({NotFoundException.class, BadRequestException.class})
    public Cart addToCart(Long id, CartRequest request) {
        Optional<Cart> oC = this.cartRepository.findById(id);
        Cart cart = oC.orElseThrow(NotFoundException::new);

        if (cart.isPayed())
            throw new BadRequestException();

        Product product = productService.getById(request.getProductId());

        int sum = product.getAmount() - request.getAmount();
        if (sum < 0)
            throw new BadRequestException();

        product.setAmount(sum);

        List<CartProduct> cartProductList = this.cartProductRepository.findAll();
        for (var item : cartProductList) {
            if (item.getProducts().getId().equals(request.getProductId())) {
                item.setCartAmount(item.getCartAmount() + request.getAmount());

                this.productService.save(product);
                this.cartProductRepository.save(item);
                return this.cartRepository.save(cart);
            }
        }

        CartProduct cartProduct = new CartProduct(cart, product, request.getAmount());
        this.cartProductRepository.save(cartProduct);
        cart.getShoppingList().add(cartProduct);
        product.getProducts().add(cartProduct);

        this.productService.save(product);
        return this.cartRepository.save(cart);
    }

    @Override
    @ExceptionHandler({NotFoundException.class, BadRequestException.class})
    public String payForCart(Long id) {
        Optional<Cart> oC = this.cartRepository.findById(id);
        Cart cart = oC.orElseThrow(NotFoundException::new);

        if (cart.isPayed())
            throw new BadRequestException();

        double sum = 0;
        for (var item : cart.getShoppingList()) {
            sum += item.getProducts().getPrice() * item.getCartAmount();
        }
        cart.setPayed(true);
        this.cartRepository.save(cart);
        return String.valueOf(sum);
    }
}
