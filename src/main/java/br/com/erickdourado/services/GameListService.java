package br.com.erickdourado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erickdourado.dto.GameListDTO;
import br.com.erickdourado.entities.GameList;
import br.com.erickdourado.projections.GameMinProjection;
import br.com.erickdourado.repositories.GameListRepository;
import br.com.erickdourado.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> gameList = gameListRepository.findAll();
		return gameList.stream().map(gl -> new GameListDTO(gl)).toList();
	}
	
	@Transactional //Dessa vez não colocamos o "readOnly", pois não estamos buscando dados.
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> gameList = gameRepository.searchByList(listId);
		
		GameMinProjection game = gameList.remove(sourceIndex);//Retirei o jogo da posição padrão
		
		gameList.add(destinationIndex, game);//Inseri o jogo na posição de destino
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, gameList.get(i).getId(), i);
		}
	}
	
}
