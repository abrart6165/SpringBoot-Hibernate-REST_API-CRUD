package com.c2k.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c2k.dto.PlayerDto;
import com.c2k.model.Player;
import com.c2k.service.serviceimpl.PlayerServiceImpl;

@RestController
@RequestMapping("/player")
public class PlayerController {
	Logger logger=LoggerFactory.getLogger(PlayerController.class);
@Autowired
PlayerServiceImpl playerServiceImpl;

@PostMapping("/saveplayer")
public ResponseEntity<String> saveplayer(@RequestBody PlayerDto pdto){
	
	Player p=playerServiceImpl.convertToPlayer(pdto);
	
	String s="Player "+playerServiceImpl.saveplayer(p).getName()+" saved with id: "+p.getId();
	HttpHeaders hh=new HttpHeaders();
	hh.set("player_abt", "from saveplayer");
	return new ResponseEntity<String>(s,hh,HttpStatus.CREATED);	
}
@GetMapping("/readallplayer")
public ResponseEntity<List<Player>> readallplayer(){
	HttpHeaders hh=new HttpHeaders();
	hh.set("player_abt", "from readallplayer");
	return new ResponseEntity<List<Player>>(playerServiceImpl.readallplayer(),hh,HttpStatus.FOUND);
}

@PostMapping("/updateplayer")
public ResponseEntity<String> updateplayer(@RequestBody Player p ){	
	String s="Player updated as "+playerServiceImpl.updateplayername(p.getName(),p.getId())+" with id: ";
	HttpHeaders hh=new HttpHeaders();
	hh.set("player_abt", "from updateplayer");
	return new ResponseEntity<String>(s,hh,HttpStatus.ACCEPTED);	
}

@GetMapping("/deleteall")
public ResponseEntity<String> deleteall(){
	playerServiceImpl.deleteall();
	String s="All players deleted successfully....";
	HttpHeaders hh=new HttpHeaders();
	hh.set("player_abt", "from deleteall");
return	new ResponseEntity<String>(s, hh, HttpStatus.OK);	
}

@GetMapping("/findbyid/{id}")
public ResponseEntity<Optional<Player>> findbyid(@PathVariable("id") int id ){
	Optional<Player> p=playerServiceImpl.findbyid(id);
	HttpHeaders hh=new HttpHeaders();
	hh.set("player_abt", "from findbyid");
	return	new ResponseEntity<Optional<Player>>(p, hh, HttpStatus.OK);
}
/*
 * @PostMapping("/deletebyid") public ResponseEntity<String> deletebyid(int id)
 */


}
