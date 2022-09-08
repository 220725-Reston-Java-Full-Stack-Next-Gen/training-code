package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//here I will be using some JPA annotations to properly map this model to my future Heroes table in my SQL database
@Data
@Entity
@Table(name="heroes")
public class Hero {

	//I need to mark this field as a primary key. Thus I will be using the following annotations:
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hero_id")
	private int id;
	
	//For any other column, you can just use the @Column annotation (unless there is a special case of multiplicity needed to be applied):
	//If I want to add a constraint like NOT NULL on a column, I would need to set the nullable property to false on that column
	@Column(name="hero_name", nullable = false, unique = true)
	private String name;
	
	@Column(name="hero_power")
	private String superPower;
	
	@Column(name="hero_isCapePresent", nullable = false)
	private boolean hasCape;

	public Hero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hero(int id, String name, String superPower, boolean hasCape) {
		super();
		this.id = id;
		this.name = name;
		this.superPower = superPower;
		this.hasCape = hasCape;
	}

	public Hero(String name, String superPower, boolean hasCape) {
		super();
		this.name = name;
		this.superPower = superPower;
		this.hasCape = hasCape;
	}
}
