package test;

import java.util.List;

import model.AccountDAO;
import model.AccountVO;

public class TestMybatis {
	public static void main(String[] args) {
		AccountDAO dao = AccountDAO.getInstance();
		//1. id로 계좌조회
		//String id= "1";
		//System.out.println("findAccountById "+dao.findAccountById(id));
		//2.계좌등록
		//AccountVO vo = new AccountVO ("2","강하늘",2000);
		//dao.registerAccount(vo);
		//System.out.println("registerAccount:"+dao.findAccountById("2"));
		//3. 전체 계좌 조회
		List<AccountVO> list = dao.getAllAccountList();
		for(AccountVO vo:list)
			System.out.println(vo);
	}
}










