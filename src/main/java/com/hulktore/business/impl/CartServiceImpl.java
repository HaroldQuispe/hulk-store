package com.hulktore.business.impl;

import com.hulktore.business.CartService;
import com.hulktore.model.Cart;
import com.hulktore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

  @Autowired
  CartRepository cartRepository;

  @Override
  public Cart save(Cart cart) {
    return cartRepository.save(cart);
  }
}
