package br.com.erickdourado.projections;

public interface GameMinProjection {
	
	/*Temos que criar essa interface e esses gets para que a "@Query" de "GameRepository" funcione corretamente.
	Temos que encaixar cada get desse com o nome que está na consulta, exemplo: tb_game.id -> getId(); 
	O tipo usado em cada get (String/Long), nós devemos pegar na entidade de cada atributo da query.
	
	Exempo: ID na classe Game é Long*/
	
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
}
