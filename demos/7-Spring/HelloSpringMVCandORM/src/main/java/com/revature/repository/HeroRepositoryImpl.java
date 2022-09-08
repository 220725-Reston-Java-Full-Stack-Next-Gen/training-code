package com.revature.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Hero;

//In order to use Spring ORM for this repository component, we must denote this class with the @Transactional annotation
@Repository
@Transactional
public class HeroRepositoryImpl implements HeroRepository {
	
	//Because Spring ORM requires transaction management, we also need its dependency of a SessionFactory instance to use here
	@Autowired
	private SessionFactory sessionFactory;

	//Note that we can now use the SessionFactory object to make SQL queries against our database by using built-in methods instead of preparedstatements!
	@Override
	public int insert(Hero hero) {
		// To insert, we can use the save() method from SessionFactory:
		return (int) sessionFactory.getCurrentSession().save(hero);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Hero> findAll() {
		// Hibernate also comes with the Criteria API (which is used to place restrictions on what kind of SQL query should the ORM be running. Criteria API = a framework-specific technique/method to query objects in Hibernate
		return sessionFactory.getCurrentSession().createCriteria(Hero.class).list();
	}

	
	@Override
	public Hero findByName(String name) {
		return (Hero) sessionFactory.getCurrentSession().createCriteria(Hero.class).add(Restrictions.like("name", name)).list().get(0);
	}

}
