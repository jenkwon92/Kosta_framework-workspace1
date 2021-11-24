package test;

import java.util.List;

import org.kosta.model.ProductMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProductMapper {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		//Mapper Proxy(MApper interface의 구현체) 의 bean id는 소문자로 시작하는 인터페이스명이다
		ProductMapper m= (ProductMapper) ctx.getBean("productMapper"); //소문자로된 interface 명이bean id 가됨
		//System.out.println("총 상품수: "+m.getTotalProductCount());
		//maker 종류 리스트를 조회
		List<String> makerList = m.getMakerKindList();
		for(String maker:makerList) {
			System.out.println(maker);
		}
		ctx.close();
	}
}
