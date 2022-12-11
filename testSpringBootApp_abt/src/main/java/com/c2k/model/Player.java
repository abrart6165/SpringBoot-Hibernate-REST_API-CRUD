package com.c2k.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
	@NotBlank
private String name;
private String team;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTeam() {
	return team;
}
public void setTeam(String team) {
	this.team = team;
}
public Player() {
	super();
}

}
