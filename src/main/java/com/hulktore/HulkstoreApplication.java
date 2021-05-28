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
		client.setFullName("Harold Quispe Condori");
		client.setDirection("Urb. Jose Ortiz Vergara");
		client.setEmail("harold.quispe.27@unsch.edu.pe");
		client.setNumberDocument("48489578");
		client.setPassword("123456");


		clientRepository.save(client);

		Product product1 = new Product();
		product1.setDescription("Edicion El caballero de la noche");
		product1.setPhoto("https://http2.mlstatic.com/muneco-batman-armadura-de-poder-luz-sonido-mattel-original-D_Q_NP_948254-MLA41440985936_042020-F.webp");
		product1.setName("Muñeco Batman");
		product1.setStock(10);
		product1.setPrice(20.0);

		productRepository.save(product1);


		Product product2 = new Product();
		product2.setDescription("es un comic del año 1990");
		product2.setName("https://i2.wp.com/www.radiodebabel.com/wp-content/uploads/2020/08/Stan-Lee-Marvel-Comics.jpeg?fit=640%2C360&ssl=1");
		product2.setStock(50);
		product2.setPrice(60.0);

		productRepository.save(product2);

	}
}
