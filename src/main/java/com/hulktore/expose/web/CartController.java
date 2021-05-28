package com.hulktore.expose.web;

import com.hulktore.business.CartService;
import com.hulktore.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/v1")
public class CartController {

  @Autowired
  CartService cartService;

  /*@PostMapping(path ="/carts", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Cart> save(@RequestBody Cart cart) {
    return new ResponseEntity<Cart>(this.cartService.save(cart), HttpStatus.CREATED);
  }*/
}
