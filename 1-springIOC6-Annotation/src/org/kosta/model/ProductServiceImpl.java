package org.kosta.model;

import org.springframework.stereotype.Service;

//Component 계열 어노테이션 -> spring container 에게 객체bean 생성할 것을 명시
@Service
public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;
	
	//@Autowired //DI 계열 어노테이션 -> spring container 에게 dependency injection 하라고 명시
	public ProductServiceImpl(ProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}
	
	
	//생성자가 오버로딩되면 @Autowired 생략불가능하지만
	//아래 생성자 메서드가 없으면 위에 @Autowired 생략가능
	/*
	public ProductServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	 */

	@Override
	public void register(String productInfo) {
		productDAO.register(productInfo);
	}

}
