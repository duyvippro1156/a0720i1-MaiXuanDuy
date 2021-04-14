package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    List<Product> findByName(String search);

    void update(int id, Product product);

    void remove(int id);

    Product findById(int id);
}
