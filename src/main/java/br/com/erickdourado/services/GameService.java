package br.com.erickdourado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erickdourado.dto.GameDTO;
import br.com.erickdourado.dto.GameMinDTO;
import br.com.erickdourado.entities.Game;
import br.com.erickdourado.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired 
	private GameRepository gameRepository;
	
	/*A anotação "@Transactional" é importante para garantir que esses métodos rodem como uma transação (atomic),
	garantindo que ou funcione até o fim ou não funcione nenhuma parte, para evitar quebras*/
	
	/*O parâmetro "readOnly = true", usamos quando queremos apenas pegar dados na transação, estamos informando que não vamos 
	inserir nada. Ao informar isso, nós economizamos processamento, pois o banco não vai abrir espaço pra inserção*/
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> games = gameRepository.findAll();
		return games.stream().map(g -> new GameMinDTO(g)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game game = gameRepository.findById(id).get();
		return new GameDTO(game);
	}

}
