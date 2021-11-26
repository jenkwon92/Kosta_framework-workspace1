package org.kosta.model;

public class ProductVO {
	private int productNo; //컬럼명은 product_no, 인스턴스변수명과 컬럼명은 불일치
	private String name;
	private String maker;
	private int price;

	/*
	 	MyBatis Framework를 사용해서 개발시에는 해당 클래스의 매개변수가 있는 생성자가 별도로 정의되어 있을때는
	 	반드시 기본생성자(디폴트 생성자)를 명시해야 한다
	 */
	public ProductVO() {
		super();
	}
	
	public ProductVO(String name, String maker, int price) {
		super();
		this.name = name;
		this.maker = maker;
		this.price = price;
	}

	public ProductVO(int productNo, String name, String maker, int price) {
		super();
		this.productNo = productNo;
		this.name = name;
		this.maker = maker;
		this.price = price;
	}
	
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductVO [productNo=" + productNo + ", name=" + name + ", maker=" + maker + ", price=" + price + "]";
	}
}
