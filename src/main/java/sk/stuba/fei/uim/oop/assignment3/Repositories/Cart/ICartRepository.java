package sk.stuba.fei.uim.oop.assignment3.Repositories.Cart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.Repositories.Product.Product;

@Repository
public interface ICartRepository extends CrudRepository<Cart, Long> {
}
