package com.revature.models;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="shops")
public class Shop {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shop_id")
	private int shopId;
	
	@Column(name="shop_name", unique=true, nullable=false)
	private String shopName;
	
	@Column(name="shop_inventory_count", nullable=false)
	private int inventoryCount;
	
	public Shop() {
		super();
	}

	public Shop(int shopId, String shopName, int inventoryCount) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.inventoryCount = inventoryCount;
	}

	public Shop(String shopName, int inventoryCount) {
		super();
		this.shopName = shopName;
		this.inventoryCount = inventoryCount;
	}
}
