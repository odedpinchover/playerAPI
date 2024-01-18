package com.example.demo.Controllers;

import com.example.demo.DTOs.PlayerDTO;
import com.example.demo.Services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/players")
public class PlayerController
{

	//todo - add validation later on
//	@Autowired
//	PlayerValidator playerValidator;

	@Autowired
	IPlayerService iPlayerService;

	@GetMapping
	public ResponseEntity<Collection<PlayerDTO>> getAllPlayers()
	{
		return new ResponseEntity<>(iPlayerService.getAllPlayers(), HttpStatus.OK) ;
	}

	@GetMapping("/{playerID}")
	public ResponseEntity getPlayerByID(@PathVariable String playerID) throws Exception
	{
		return new ResponseEntity<>(iPlayerService.getPlayerByID(playerID), HttpStatus.OK) ;
	}
}
