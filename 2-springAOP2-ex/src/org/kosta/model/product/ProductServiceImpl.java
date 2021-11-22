package org.kosta.model.product;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductServiceImpl implements ProductService {
	private Logger logger = LogManager.getLogger(getClass());
	@Override
	public void deleteProduct() {		
		System.out.println("상품정보를 삭제");
	}
	@Override
	public void findProductById() {		
		System.out.println("아이디로 상품정보를 검색");
		logger.info("findProductById");
	}
	@Override
	public void findProductListByMaker() {	
		System.out.println("제조사로 상품리스트를 검색");
		logger.info("findProductListByMaker");
	}
}
