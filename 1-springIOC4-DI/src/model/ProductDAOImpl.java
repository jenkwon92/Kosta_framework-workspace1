package model;

public class ProductDAOImpl implements ProductDAO {
	@Override
	public String findProductById(String id) {
		if(id.equals("1"))
			return  "1 테라 하이트 진로 1410원";
		else
			return null;
	}
}
