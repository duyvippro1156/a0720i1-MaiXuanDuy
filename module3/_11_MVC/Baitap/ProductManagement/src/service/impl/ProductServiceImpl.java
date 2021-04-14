package service.impl;

import model.Product;
import service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService {
    public static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "sach", 10000, "giao duc cong dan", "NXB giáo dục"));
        productMap.put(2, new Product(2, "vo", 5000, "vo 100 trang", "Thien Long"));
        productMap.put(3, new Product(3, "but", 20000, "but bi xanh", "Thien Long"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public List<Product> findByName(String search) {
        List<Product> find = new ArrayList<>();
        for (int i = 0; i < findAll().size(); i++) {
            if (findAll().get(i).getName().contains(search)) {
                find.add(findAll().get(i));
            }
        }
        return find;
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }
}
