package com.hulktore.business.impl;

import com.hulktore.business.ClientService;
import com.hulktore.model.Client;
import com.hulktore.model.Product;
import com.hulktore.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        clients = (List<Client>) clientRepository.findAll();
        return clients;
    }

    @Override
    public Client findById(Integer idClient) {
        return null;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Integer idClient) {
        clientRepository.deleteById(idClient);
    }
}
