package br.com.erickdourado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erickdourado.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
