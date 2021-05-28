package com.hulktore;

import com.hulktore.business.ProductService;
import com.hulktore.model.Client;
import com.hulktore.model.Product;
import com.hulktore.repository.ClientRepository;
import com.hulktore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HulkstoreApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(HulkstoreApplication.class, args);
	}

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		Client client = new Client();
		client.setFullName("sfsfs");
		client.setDirection("fsfs");
		client.setEmail("fsfsfs");
		client.setNumberDocument("7578574");

		clientRepository.save(client);

		Product product1 = new Product();
		product1.setDescription("sfsfs");
		product1.setStock(10);
		product1.setPrice(20.0);

		productRepository.save(product1);


		Product product2 = new Product();
		product2.setDescription("sfsfs");
		product2.setStock(50);
		product2.setPrice(60.0);

		productRepository.save(product2);

	}
}
