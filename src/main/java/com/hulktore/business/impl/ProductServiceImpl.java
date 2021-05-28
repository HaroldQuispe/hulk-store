package com.hulktore.business.impl;

import com.hulktore.business.ProductService;
import com.hulktore.model.Product;
import com.hulktore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        products = productRepo.findAll();

        return products;
    }

    @Override
    public Product findById(Integer idProduct) {

       return productRepo.getById(idProduct);
    }

    @Override
    public Product save(Product product) {

        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) {

        return productRepo.save(product);
    }

    @Override
    public void delete(Integer idProduct) {
        productRepo.deleteById(idProduct);
    }

    /*@Override
    public void updateStock(Integer idProduct, Integer quantity) {
        Product product = this.findById(idProduct);
        product.setStock(product.getStock()-quantity);
        this.update(product);
    }*/

}
