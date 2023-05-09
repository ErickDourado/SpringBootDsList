package br.com.erickdourado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erickdourado.dto.GameMinDto;
import br.com.erickdourado.entities.Game;
import br.com.erickdourado.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired 
	private GameRepository gameRepository;
	
	public List<GameMinDto> findAll() {
		List<Game> games = gameRepository.findAll();
		return games.stream().map(g -> new GameMinDto(g)).toList();
	}

}
