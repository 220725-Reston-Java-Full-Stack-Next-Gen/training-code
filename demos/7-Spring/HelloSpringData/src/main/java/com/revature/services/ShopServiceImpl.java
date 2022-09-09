package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Shop;
import com.revature.repositories.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ShopRepository shopRepo;

	@Override
	public boolean createShop(Shop shop) {
		int pk = shopRepo.save(shop).getShopId();
		return (pk > 0) ? true : false;
	}

	@Override
	public Shop getShopById(int id) {
		//this is why Azhya made a custom findById method back in the repository
		//Pro: more concise approach via the setup process for the other way
		//Con: familar with how streams work
		return shopRepo.findById(id).stream().findFirst().get();
	}

	@Override
	public List<Shop> getAllShops() {
		return shopRepo.findAll();
	}

	@Override
	public boolean updateShop(Shop shop) {
		return shopRepo.update(shop.getShopName(), shop.getInventoryCount(), shop.getShopId());
	}

	@Override
	public boolean deleteShop(Shop shop) {
		shopRepo.delete(shop);
		return true;
	}

}
