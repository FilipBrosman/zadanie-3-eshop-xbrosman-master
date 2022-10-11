package sk.stuba.fei.uim.oop.assignment3.Repositories.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmountResponse {
    private Integer amount;
    public AmountResponse(Product product) {
        this.amount = product.getAmount();
    }
}
