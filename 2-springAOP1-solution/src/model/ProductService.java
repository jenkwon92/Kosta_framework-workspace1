package model;

import java.util.ArrayList;

public interface ProductService {
	void deleteProductByNo(int no);
	String findProductByNo(int no);
	ArrayList<String> findProductListByMaker(String maker);
}
