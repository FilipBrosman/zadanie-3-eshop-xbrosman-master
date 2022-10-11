package sk.stuba.fei.uim.oop.assignment3.Services.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import sk.stuba.fei.uim.oop.assignment3.Exceptions.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Product.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product create(ProductRequest request) {
        Product newProduct = new Product();
        newProduct.setName(request.getName());
        newProduct.setDescription(request.getDescription());
        newProduct.setAmount(request.getAmount());
        newProduct.setUnit(request.getUnit());
        newProduct.setPrice(request.getPrice());
        return this.productRepository.save(newProduct);
    }

    @Override
    @ExceptionHandler({NotFoundException.class})
    public Product getProduct(Long id) {
        Optional<Product> oP = this.productRepository.findById(id);
        return oP.orElseThrow(NotFoundException::new);
    }

    @Override
    @ExceptionHandler({NotFoundException.class})
    public Product updateProduct(Long id, UpdateProductRequest request) {
        Optional<Product> oP = this.productRepository.findById(id);
        Product p = oP.orElseThrow(NotFoundException::new);

        if (request.getName() != null)
            if (!request.getName().isBlank())
                p.setName(request.getName());

        if (request.getDescription() != null)
            if (!request.getDescription().isBlank())
                p.setDescription(request.getDescription());
        return this.productRepository.save(p);
    }

    @Override
    @ExceptionHandler({NotFoundException.class})
    public void delete(Long id) {
        Optional<Product> oP = this.productRepository.findById(id);
        this.productRepository.delete(oP.orElseThrow(NotFoundException::new));
    }

    @Override
    @ExceptionHandler({NotFoundException.class})
    public Product getAmount(Long id) {
        Optional<Product> oP = this.productRepository.findById(id);
        return oP.orElseThrow(NotFoundException::new);
    }

    @Override
    @ExceptionHandler({NotFoundException.class})
    public Product updateAmount(Long id, AmountRequest request) {
        Optional<Product> oP = this.productRepository.findById(id);
        Product p = oP.orElseThrow(NotFoundException::new);
        p.setAmount(p.getAmount() + request.getAmount());
        return this.productRepository.save(p);
    }

    @Override
    @ExceptionHandler({NotFoundException.class})
    public Product getById(Long productId) {
        Optional<Product> oP = this.productRepository.findById(productId);
        return oP.orElseThrow(NotFoundException::new);
    }

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }
}
