package com.hulktore.expose.web;

import com.hulktore.business.ClientService;
import com.hulktore.model.Client;
import com.hulktore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store/v1")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> findAll() {
        return new ResponseEntity<List<Client>>(this.clientService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getById(@PathVariable("id") Integer idProduct) {
        return new ResponseEntity<Client>(this.clientService.findById(idProduct), HttpStatus.ACCEPTED);
    }

    @PostMapping(path ="/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> save(@RequestBody Client client) {
        return new ResponseEntity<Client>(this.clientService.save(client), HttpStatus.CREATED);
    }

    @PutMapping(path = "/clients/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> update(@RequestBody Client client) {
        return new ResponseEntity<Client>(this.clientService.update(client), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable("id") Integer idClient){
        clientService.delete(idClient);
    }

}
