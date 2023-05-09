package br.com.erickdourado.dto;

import br.com.erickdourado.entities.Game;

public class GameMinDto {
	
	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;

	public GameMinDto() {}

	public GameMinDto(Game game) {
		this.id = game.getId();
		this.title = game.getTitle();
		this.year = game.getYear();
		this.imgUrl = game.getImgUrl();
		this.shortDescription = game.getShortDescripton();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
}
