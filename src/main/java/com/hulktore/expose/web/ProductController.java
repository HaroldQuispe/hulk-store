package com.hulktore.expose.web;

import com.hulktore.business.ProductService;
import com.hulktore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store/v1")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<List<Product>>(this.productService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Integer idProduct) {
        return new ResponseEntity<Product>(this.productService.findById(idProduct), HttpStatus.ACCEPTED);
    }

    @PostMapping(path ="/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<Product>(this.productService.save(product), HttpStatus.CREATED);
    }

    @PutMapping(path = "/products/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return new ResponseEntity<Product>(this.productService.update(product), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") Integer idProduct){
        productService.delete(idProduct);
    }

    @PutMapping("products/{id}")
    public void updateStock(@PathVariable("id") Integer idProduct, Integer quantity){
        productService.updateStock(idProduct,quantity);
    }
}
