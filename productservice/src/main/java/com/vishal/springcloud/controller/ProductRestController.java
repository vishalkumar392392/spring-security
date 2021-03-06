package com.vishal.springcloud.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.vishal.springcloud.model.Coupon;
import com.vishal.springcloud.model.Product;
import com.vishal.springcloud.repository.ProductRepository;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Autowired
	private ProductRepository repo;

	@Value("${couponCodeURL}")
	private String couponCodeURL;

	@PostMapping("/products")
	public Product create(@RequestBody Product product) throws RestClientException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		URI url = new URI(couponCodeURL + product.getCouponCode());
		ResponseEntity<Coupon> forEntity = restTemplate.getForEntity(url, Coupon.class);
		Coupon coupon = forEntity.getBody();
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);
	}

}
