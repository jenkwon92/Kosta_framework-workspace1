package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.ProductService;

public class TestDI {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
		ProductService service = (ProductService) factory.getBean("productService");
		System.out.println(service.findProductById("1"));
		factory.close();
	}
}
