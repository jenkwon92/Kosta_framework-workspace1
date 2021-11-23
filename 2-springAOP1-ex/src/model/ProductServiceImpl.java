package model;

import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {

	@Override
	public void deleteProductByNo(int no) {
		System.out.println(no+"상품번호 상품정보 삭제");
		
	}

	@Override
	public String findProductByNo(int no) {
		System.out.println("**시스템 횡단 관심사(공통기능)**");
		return no+"상품번호 상품정보";
	}

	@Override
	public ArrayList<String> findProductListByMaker(String maker) {
		System.out.println("**시스템 횡단 관심사(공통기능)**");
		ArrayList<String> list = new ArrayList<String>();
		list.add("카스");
		list.add("테라");
		list.add("참이슬");
		return list;
	}

}
