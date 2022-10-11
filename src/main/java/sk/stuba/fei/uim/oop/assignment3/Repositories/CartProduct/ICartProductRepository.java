package sk.stuba.fei.uim.oop.assignment3.Repositories.CartProduct;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartProductRepository extends CrudRepository<CartProduct, Long> {
    List<CartProduct> findAll();
}
