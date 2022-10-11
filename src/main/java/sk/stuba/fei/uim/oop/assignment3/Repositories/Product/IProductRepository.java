package sk.stuba.fei.uim.oop.assignment3.Repositories.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
}
