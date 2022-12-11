package com.c2k.dto;

import com.c2k.model.Player;

public class PlayerDto{
	private int id;
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
	public PlayerDto() {
		super();
	}

}
