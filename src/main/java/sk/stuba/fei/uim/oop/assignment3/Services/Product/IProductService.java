package sk.stuba.fei.uim.oop.assignment3.Services.Product;

import sk.stuba.fei.uim.oop.assignment3.Repositories.Product.AmountRequest;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Product.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Product.Product;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Product.UpdateProductRequest;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product create(ProductRequest request);

    Product getProduct(Long id);

    Product updateProduct(Long id, UpdateProductRequest request);

    void delete(Long id);

    Product getAmount(Long id);

    Product updateAmount(Long id, AmountRequest request);

    Product getById(Long productId);

    Product save(Product product);
}
