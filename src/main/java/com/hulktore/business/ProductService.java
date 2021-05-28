package com.hulktore.business;

import com.hulktore.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    public Product findById(Integer idProduct);
    public Product save(Product product);
    public Product update(Product product);
    public void delete(Integer idProduct);
    public void updateStock(Integer idProduct, Integer quantity);
}
