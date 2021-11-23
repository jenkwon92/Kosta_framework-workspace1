package org.kosta.model.service;

public interface ProductService {
	public void register(String productInfo);
	public String findById(String id);
	public String findByMaker(String maker);
}
