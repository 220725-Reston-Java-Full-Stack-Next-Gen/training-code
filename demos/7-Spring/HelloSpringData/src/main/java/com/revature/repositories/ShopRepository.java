package com.revature.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.Shop;

@Repository
@Transactional
public interface ShopRepository extends JpaRepository<Shop, Integer>{
	//here, there will be very little code inside of this interface because we will be implementing the JpaRepository interface and will use its built-in methods to perform SQL operations against our database
	@Query(value="UPDATE shops SET shop_name=?1, shop_inventory_count=?2 WHERE shop_id=?3", nativeQuery=true)
	public boolean update(String name, int invCount, int id);
}
