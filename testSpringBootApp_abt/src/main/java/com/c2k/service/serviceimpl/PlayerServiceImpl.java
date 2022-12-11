package com.c2k.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2k.dao.PlayerDao;
import com.c2k.dto.PlayerDto;
import com.c2k.model.Player;
import com.c2k.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{
	@Autowired
	PlayerDao pdao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public Player saveplayer(Player p) {
		return pdao.save(p);
	}
	@Override
	public List<Player> readallplayer() {
		return pdao.findAll();
	}
	@Override
	public int updateplayername(String name,int id) {
	
		return pdao.updateplayername(name, id);
	}
	@Override
	public void deleteall() {
		pdao.deleteAll();
		
	}
	@Override
	public void deletebyid(int id) {
		pdao.deleteById(id);		
	}
	
	@Override
	public Optional<Player> findbyid(int id) {
		return pdao.findById(id);
		
		
	}
	
	
	@Override
	public Player convertToPlayer(PlayerDto pdto) {
		Player p=this.modelMapper.map(pdto, Player.class);
		return p;
	}
	@Override
	public PlayerDto convertToPlayerDto(Player p) {
		PlayerDto pdto=this.modelMapper.map(p, PlayerDto.class);
		return pdto;
	}
	
	
	
	
	
	

}
