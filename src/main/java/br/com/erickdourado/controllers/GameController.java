package br.com.erickdourado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erickdourado.dto.GameMinDto;
import br.com.erickdourado.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public ResponseEntity<List<GameMinDto>> findAll() {
		return ResponseEntity.ok(gameService.findAll());
	}

}
