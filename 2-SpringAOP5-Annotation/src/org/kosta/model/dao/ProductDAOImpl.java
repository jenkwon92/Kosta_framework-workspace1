package org.kosta.model.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Override
	public void register(String productInfo) {
		System.out.println(getClass().getName()+" "+productInfo+" register");
	}
	@Override
	public String findById(String id) {
		System.out.println(getClass().getName()+" "+id+" findById");
		return id+"아이디 상품정보";
	}
	@Override
	public String findByMaker(String maker) {
		System.out.println(getClass().getName()+" "+maker+" findByMaker");
		return maker+" 상품리스트";
	}

}
