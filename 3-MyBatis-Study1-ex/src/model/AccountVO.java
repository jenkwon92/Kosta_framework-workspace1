package model;

public class AccountVO {
	private String id;
	private String name;
	private int balance;
	public AccountVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountVO(String id, String name, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountVO [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
}
