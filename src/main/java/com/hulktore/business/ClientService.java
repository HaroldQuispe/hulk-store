package com.hulktore.business;

import com.hulktore.model.Client;
import com.hulktore.model.Product;

import java.util.List;

public interface ClientService {

    public List<Client> findAll();
    public Client findById(Integer idClient);
    public Client save(Client client);
    public Client update(Client client);
    public void delete(Integer idClient);
}
