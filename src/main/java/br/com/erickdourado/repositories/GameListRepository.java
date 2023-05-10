package br.com.erickdourado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erickdourado.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
