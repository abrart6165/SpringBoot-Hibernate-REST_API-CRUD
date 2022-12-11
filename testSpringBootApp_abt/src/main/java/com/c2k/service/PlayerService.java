package com.c2k.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.c2k.dto.PlayerDto;
import com.c2k.model.Player;

public interface PlayerService {
	
public Player saveplayer(Player p);
public List<Player> readallplayer();
public int updateplayername(String name,int id);
public void deleteall();
public void deletebyid(int id);
public Optional<Player> findbyid(int id);

public Player convertToPlayer(PlayerDto pdto); 
public PlayerDto convertToPlayerDto(Player p);
}

