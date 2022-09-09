package com.revature.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.Candy;

@Repository
@Transactional
public interface CandyRepository extends JpaRepository<Candy, Integer>{
	//here, there will be very little code inside of this interface because we will be extending the JpaRepository interface and will use its built-in methods to perform SQL operations against our database

	//here I can also create my own custom queries by using the @Query annotation
	@Query(value="UPDATE candies SET candy_name=?1, candy_price=?2 WHERE candy_id=?3", nativeQuery=true)
	public boolean update(String name, double price, int id);
	
	@Query(value="SELECT * FROM candies WHERE candy_id=?1", nativeQuery=true)
	public Candy findById(int id);
}
