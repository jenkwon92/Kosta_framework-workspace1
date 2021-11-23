package org.kosta.model.dao;

public interface ProductDAO {
	public void register(String productInfo);
	public String findById(String id);
	public String findByMaker(String maker);
}
