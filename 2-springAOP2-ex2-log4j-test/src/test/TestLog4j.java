package test;

import org.kosta.model.service.ProductService;

import model.MemberService;

public class TestLog4j {
	public static void main(String[] args) {
		//Root level이 warn 이상이므로 warn,error,fatal이 로깅	
		MemberService service = new MemberService();
		service.logteset();
		System.out.println("*******************");
		//별도로 debug level로 지정했으므로 debug이상이 logging
		ProductService ps = new ProductService();
		ps.deleteProduct();
		ps.findProduct();
		ps.register();
	}
}
