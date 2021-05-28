package com.hulktore.model;

import com.hulktore.model.api.CartDetail;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Data
@Entity
@Table(name = "Cart")
@Getter
@Setter
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Transient
  private List<CartDetail> cartDetails;
  private Integer idClient;

}
