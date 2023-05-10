package br.com.erickdourado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erickdourado.dto.GameListDTO;
import br.com.erickdourado.entities.GameList;
import br.com.erickdourado.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> gameList = gameListRepository.findAll();
		return gameList.stream().map(gl -> new GameListDTO(gl)).toList();
	}

}
