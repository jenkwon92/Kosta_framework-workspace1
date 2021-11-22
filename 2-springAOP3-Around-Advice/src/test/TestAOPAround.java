package test;

import java.sql.SQLException;

import org.kosta.model.InventoryException;
import org.kosta.model.PersonService;
import org.kosta.model.ProductService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * Around Advice test 예제
 *  : Around Advice 는 before, after, after-returning , after-throwing 의 4가지 advice를 모두 적용할 수 있는 advice
 */
public class TestAOPAround {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory=new ClassPathXmlApplicationContext("spring-config.xml");
		PersonService personService=(PersonService)factory.getBean("personService");
		System.out.println(personService.toString());
		//이전 예제와는 다르게 core가 interface를 implements 하지 않으므로 상속을 이용한 proxy를 spring container가 반환
		//org.kosta.model.PersonService$$EnhancerBySpringCGLIB$$3b9f2b8d ->proxy
		System.out.println(personService.getClass().getName());
		ProductService productService=(ProductService)factory.getBean("productService");
		personService.register();
		System.out.println(personService.getNick());
		productService.register("진라면");
		System.out.println(productService.getMaker());
		//아래는 InventoryException 발생시 AOP 적용시켜 보기 위한 코드
		// sellProduct core 메서드는 InventoryException이 발생되고 
		// buyProduct core 메서드는 SQLException이 발생된다 
		// 요구사항 : InventoryException 이 발생되어 throws 될 때 AOP 에서 
		//             특정한 횡단관심사 로직을 적용하도록 처리 
		try {
			productService.sellProduct(12);
		} catch (InventoryException e) {//재고수량보다 주문수량이 많으면 InventoryException 발생 
			System.out.println("main:"+e.getMessage());
		}
		try {
			productService.buyProduct(0);
		} catch (SQLException e) {
			System.out.println("main:"+e.getMessage());
		}
		factory.close();
	}
}












