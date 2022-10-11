package sk.stuba.fei.uim.oop.assignment3.Repositories.Cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {
    private Long productId;
    private Integer amount;
}
