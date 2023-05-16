package br.com.erickdourado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erickdourado.dto.GameListDTO;
import br.com.erickdourado.dto.GameMinDTO;
import br.com.erickdourado.dto.ReplacementDTO;
import br.com.erickdourado.services.GameListService;
import br.com.erickdourado.services.GameService;

@RestController
@RequestMapping("/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public ResponseEntity<List<GameListDTO>> findAll() {
		return ResponseEntity.ok(gameListService.findAll());
	}
	
	@GetMapping("/{listId}/games")
	public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId) {
		return ResponseEntity.ok(gameService.findByList(listId));
	}

	@PostMapping("/{listId}/replacement")
	public ResponseEntity<Void> move(@PathVariable Long listId, @RequestBody ReplacementDTO replacementDTO) {
		gameListService.move(listId, replacementDTO.getSourceIndex(), replacementDTO.getDestinationIndex());
		return ResponseEntity.noContent().build();
	}
}
