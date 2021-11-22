package org.kosta.model.product;

public class ProductServiceImpl implements ProductService {	
	@Override
	public void deleteProduct() {		
		System.out.println("상품정보를 삭제");
	}
	@Override
	public void findProductById() {		
		System.out.println("아이디로 상품정보를 검색");
		
	}
	@Override
	public void findProductListByMaker() {	
		System.out.println("제조사로 상품리스트를 검색");
		
	}
}
