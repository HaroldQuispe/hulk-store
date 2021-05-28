package com.hulktore.business.impl;

import com.hulktore.business.CheckoutService;
import com.hulktore.business.ProductService;
import com.hulktore.model.Buy;
import com.hulktore.model.Cart;
import com.hulktore.model.Client;
import com.hulktore.model.Product;
import com.hulktore.model.api.CartDetail;
import com.hulktore.repository.BuyRepository;
import com.hulktore.repository.ClientRepository;
import com.hulktore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CheckoutServiceImpl implements CheckoutService {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  ClientRepository clientRepository;

  @Autowired
  BuyRepository buyRepository;

  @Override
  public void checkouted(Cart cart) {
    if (!validateQuantityProduct(cart)) {
      System.out.println("no procede");
    }

    Buy buy = new Buy();

    Client client = clientRepository.findById(cart.getIdClient()).get();

    buy.setAmount(calculateAmount(cart));
    buy.setClient(client);
    buy.setDate(new Date());

    Buy newBuy = buyRepository.save(buy);

    if (newBuy.getId() != null) {
      for (CartDetail detail : cart.getCartDetails()) {
        //update stock
        Product product = productRepository.findById(detail.getIdProduct()).get();
        product.setStock(product.getStock() - detail.getQuantity());
        productRepository.save(product);
      }
    }


  }

  private Double calculateAmount(Cart cart) {

    Double amount = 0.0;
    for (CartDetail detail : cart.getCartDetails()) {
      Product product = productRepository.findById(detail.getIdProduct()).get();
      amount += product.getPrice() * detail.getQuantity();
    }

    return amount;
  }

  private boolean validateQuantityProduct(Cart cart) {

    List<Product> products = productRepository.findAll();
    boolean isValidStock = true;
    for (CartDetail detail : cart.getCartDetails()) {
      Product product = productRepository.findById(detail.getIdProduct()).get();
      if (product.getStock() == 0) {
        isValidStock = false;
      }
    }
    return isValidStock;
  }
}
