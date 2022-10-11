package sk.stuba.fei.uim.oop.assignment3.Repositories.Product;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Integer amount;
    private String unit;
    private double price;

    public ProductResponse(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.amount = p.getAmount();
        this.unit = p.getUnit();
        this.price = p.getPrice();
    }
}