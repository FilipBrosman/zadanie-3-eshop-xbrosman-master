package sk.stuba.fei.uim.oop.assignment3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Product.*;
import sk.stuba.fei.uim.oop.assignment3.Services.Product.IProductService;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductResponse> getProducts() {
        return this.productService.getAllProducts().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductResponse getProducts(@PathVariable("id") Long id) {
        return new ProductResponse(this.productService.getProduct(id));
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable("id") Long id, @RequestBody UpdateProductRequest request) {
        return new ProductResponse(this.productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        this.productService.delete(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest request) {
        return new ProductResponse(this.productService.create(request));
    }

    @GetMapping("/{id}/amount")
    public AmountResponse getAmount(@PathVariable("id") Long id) {
        return new AmountResponse(this.productService.getAmount(id));
    }

    @PostMapping("/{id}/amount")
    public AmountResponse updateAmount(@PathVariable("id") Long id, @RequestBody AmountRequest request) {
        return new AmountResponse(this.productService.updateAmount(id, request));
    }
}
