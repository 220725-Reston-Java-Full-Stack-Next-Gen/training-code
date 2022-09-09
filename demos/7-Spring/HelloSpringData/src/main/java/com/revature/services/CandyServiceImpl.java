package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Candy;
import com.revature.repositories.CandyRepository;

@Service
@Transactional //Q: Why do we needed this annotation for this service class? Because 1) the service layer relies on the dao layer therefore making the dao the dependency that needs to be injected into this service and 2) the dao layer requires the ability to do transaction management
public class CandyServiceImpl implements CandyService{
	
	@Autowired
	private CandyRepository candyRepo;
	
	@Autowired
	public CandyServiceImpl(CandyRepository candyRepo) {
		this.candyRepo = candyRepo;
	}

	@Override
	public boolean createCandy(Candy candy) {
		int pk = candyRepo.save(candy).getId();
		return (pk > 0) ? true : false;
	}

	@Override
	public Candy getCandyById(int id) {
		return candyRepo.findById(id);
	}

	@Override
	public List<Candy> getAllCandies() {
		return candyRepo.findAll();
	}

	@Override
	public boolean updateCandy(Candy candy) {
		return candyRepo.update(candy.getName(), candy.getPrice(), candy.getId());
	}

	@Override
	public boolean deleteCandy(Candy candy) {
		candyRepo.delete(candy);
		return true;
	}

}
