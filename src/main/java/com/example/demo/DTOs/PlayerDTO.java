package com.example.demo.DTOs;

import java.util.Date;

public class PlayerDTO
{

	private String playerID;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	private String birthCountry;
	private String birthState;
	private String birthCity;
	private int deathYear;
	private int deathMonth;
	private int deathDay;
	private String deathCountry;
	private String deathState;
	private String deathCity;
	private String nameFirst;
	private String nameLast;
	private String nameGiven;
	private int weight;
	private int height;
	private String bats;
	private String throwes;
	private Date debut;
	private Date finalGame;
	private String retroID;
	private String bbrefID;

	public PlayerDTO(String playerID, int birthYear, int birthMonth, int birthDay, String birthCountry, String birthState,
			String birthCity, int deathYear, int deathMonth, int deathDay, String deathCountry, String deathState,
			String deathCity, String nameFirst, String nameLast, String nameGiven, int weight, int height, String bats,
			String throwes, Date debut, Date finalGame, String retroID, String bbrefID)
	{
		this.playerID = playerID;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.birthCountry = birthCountry;
		this.birthState = birthState;
		this.birthCity = birthCity;
		this.deathYear = deathYear;
		this.deathMonth = deathMonth;
		this.deathDay = deathDay;
		this.deathCountry = deathCountry;
		this.deathState = deathState;
		this.deathCity = deathCity;
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.nameGiven = nameGiven;
		this.weight = weight;
		this.height = height;
		this.bats = bats;
		this.throwes = throwes;
		this.debut = debut;
		this.finalGame = finalGame;
		this.retroID = retroID;
		this.bbrefID = bbrefID;
	}

	public String getPlayerID()
	{
		return playerID;
	}

	public int getBirthYear()
	{
		return birthYear;
	}

	public int getBirthMonth()
	{
		return birthMonth;
	}

	public int getBirthDay()
	{
		return birthDay;
	}

	public String getBirthCountry()
	{
		return birthCountry;
	}

	public String getBirthState()
	{
		return birthState;
	}

	public String getBirthCity()
	{
		return birthCity;
	}

	public int getDeathYear()
	{
		return deathYear;
	}

	public int getDeathMonth()
	{
		return deathMonth;
	}

	public int getDeathDay()
	{
		return deathDay;
	}

	public String getDeathCountry()
	{
		return deathCountry;
	}

	public String getDeathState()
	{
		return deathState;
	}

	public String getDeathCity()
	{
		return deathCity;
	}

	public String getNameFirst()
	{
		return nameFirst;
	}

	public String getNameLast()
	{
		return nameLast;
	}

	public String getNameGiven()
	{
		return nameGiven;
	}

	public int getWeight()
	{
		return weight;
	}

	public int getHeight()
	{
		return height;
	}

	public String getBats()
	{
		return bats;
	}

	public String getThrowes()
	{
		return throwes;
	}

	public Date getDebut()
	{
		return debut;
	}

	public Date getFinalGame()
	{
		return finalGame;
	}

	public String getRetroID()
	{
		return retroID;
	}

	public String getBbrefID()
	{
		return bbrefID;
	}
}
