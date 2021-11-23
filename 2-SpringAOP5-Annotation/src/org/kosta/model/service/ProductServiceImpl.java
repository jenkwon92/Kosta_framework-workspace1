package org.kosta.model.service;

import org.kosta.model.dao.ProductDAO;

public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO;
	
	public ProductServiceImpl(ProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}
	@Override
	public void register(String productInfo) {
		productDAO.register(productInfo);
	}
	@Override
	public String findById(String id) {
		return productDAO.findById(id);
	}
	@Override
	public String findByMaker(String maker) {
		return productDAO.findByMaker(maker);
	}

}
