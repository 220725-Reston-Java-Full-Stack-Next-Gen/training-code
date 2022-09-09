package com.revature.models;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="candies")
public class Candy {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="candy_id")
	private int id;
	
	@Column(name="candy_name", unique=true, nullable=false)
	private String name;
	
	@Column(name="candy_price", nullable=false)
	private double price;
	
	//here is where I would set up my foreign key relationship between these two classes. You can do so by using the following annotations:
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="candy_shop", referencedColumnName = "shop_id")
	private Shop shop;
	
	public Candy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candy(int id, String name, double price, Shop shop) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.shop = shop;
	}

	public Candy(String name, double price, Shop shop) {
		super();
		this.name = name;
		this.price = price;
		this.shop = shop;
	}
}
