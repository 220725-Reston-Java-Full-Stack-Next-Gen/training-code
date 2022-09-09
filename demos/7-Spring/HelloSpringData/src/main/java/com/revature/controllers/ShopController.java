package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.CREATION_FAILED;
import static com.revature.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.DELETION_FAILED;
import static com.revature.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.UPDATE_FAILED;
import static com.revature.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.ClientMessage;
import com.revature.models.Shop;
import com.revature.services.ShopService;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

	private static Logger log = Logger.getLogger(ShopController.class);
	
	@Autowired
	private ShopService shopServ;
	
	//create new shop
	@PostMapping("/create")
	public ClientMessage createShop(@RequestBody Shop shop) {
		//Note we don't need the @ResponseBody annotation here because it is already included for all methods inside of this class thanks to the @RestController annotation
		return shopServ.createShop(shop) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	//get shop by id
	@GetMapping("/findById")
	public Shop getShopById(@RequestParam(value="id", name="id") int id) {
		log.info("TEST ID PARAM IS MAKING SERVICE CALL: " + shopServ.getShopById(id));
		return shopServ.getShopById(id);
	}
	
	//get all shops
	@GetMapping("/findAll")
	public List<Shop> getAllShops(){
		return shopServ.getAllShops();
	}
	
	//for updates, typically you would use the PUT verb to do those HTTP requests
	@PutMapping("/update")
	public ClientMessage updateShop(@RequestBody Shop shop) {
		return shopServ.updateShop(shop) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	}

	//Obviously you would need to use the @DeleteMapping for all deletion requests
	@DeleteMapping("/delete")
	public ClientMessage deleteShop(@RequestBody Shop shop) {
		return shopServ.deleteShop(shop) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
}
