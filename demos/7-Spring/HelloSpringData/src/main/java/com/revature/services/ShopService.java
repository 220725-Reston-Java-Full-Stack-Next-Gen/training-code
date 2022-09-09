package com.revature.services;

import java.util.List;

import com.revature.models.Shop;

public interface ShopService {

	//create a new shop
	public boolean createShop(Shop shop);
	
	//get shop by id
	public Shop getShopById(int id);
	
	//get all shops
	public List<Shop> getAllShops();
	
	//update shop
	public boolean updateShop(Shop shop);
	
	//delete shop
	public boolean deleteShop(Shop shop);
}
