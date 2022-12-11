package com.c2k.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.c2k.model.Player;
@Repository
public interface PlayerDao extends JpaRepository<Player, Integer>{
	
	@Transactional
	@Modifying
	 @Query("UPDATE Player p SET p.name =?1 WHERE p.id =?2")
	public int updateplayername(String name,int id);
	}
