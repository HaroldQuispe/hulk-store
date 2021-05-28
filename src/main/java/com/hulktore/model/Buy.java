package com.hulktore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Buy")
@Getter
@Setter
public class Buy {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Double amount;
  private Date date;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

}