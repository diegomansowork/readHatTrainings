package com.redhat.coolstore.productcataloglab1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import com.redhat.coolstore.productcataloglab1.service.ProductCatalogService;


@SpringBootTest
@ActiveProfiles("dev")
class ProductCatalogLab1ApplicationTests {
	
	@Autowired
	private ProductCatalogService productCatalogService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testDefaultProductList() {
		String message = productCatalogService.sayHello();
		assertTrue(message!=null);
		assertEquals(message,"Hey Developer!");
	}

}
