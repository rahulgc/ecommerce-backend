package com.ecom.backend.dto;

import com.ecom.backend.entity.Product;

public class ProductDTO {
	
	private int productId;
	private String productName;
	private double price;
	private boolean stock;
	private int quantity;
	private boolean live;
	private String imageAddress;
	private String productDesc;
	
	public ProductDTO(int productId, String productName, double price, boolean stock, int quantity, boolean live,
			String imageAddress, String productDesc) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.quantity = quantity;
		this.live = live;
		this.imageAddress = imageAddress;
		this.productDesc = productDesc;
	}

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public String getImageAddress() {
		return imageAddress;
	}

	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", price=" + price + ", stock="
				+ stock + ", quantity=" + quantity + ", live=" + live + ", imageAddress=" + imageAddress
				+ ", productDesc=" + productDesc + "]";
	}
	
	public static Product prepareProduct(ProductDTO pd) {
		Product p =new Product();
		p.setProductId(pd.getProductId());
		p.setProductName(pd.getProductName());
		p.setPrice(pd.getPrice());
		p.setQuantity(pd.getQuantity());
		p.setLive(pd.isLive());
		p.setProductDesc(pd.getProductDesc());
		p.setStock(pd.isStock());
		p.setImageAddress(pd.getImageAddress());
		
		return p;
		
	}
	

}
