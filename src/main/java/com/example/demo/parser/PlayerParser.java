package com.example.demo.parser;

import com.example.demo.Consts.Constants;
import com.example.demo.DTOs.PlayerDTO;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class PlayerParser
{
	public static Map<String, PlayerDTO> parsePlayerFile(String fileName)
	{
		Map<String, PlayerDTO> DB;
		Map<String, Integer> location;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("start " + dtf.format(now));
		try
		{
			DB = new HashMap<>();
			location = new HashMap<>();
			ClassPathResource resource = new ClassPathResource(fileName);
			InputStream inputStream = resource.getInputStream();
			InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			BufferedReader reader = new BufferedReader(streamReader);
			int lineNumber=1;
			for (String line; (line = reader.readLine()) != null; )
			{
				String[] split = line.split(",");
				if (lineNumber == 1)
				{
					for(int i=0 ; i<split.length  ;i++){
						location.put(split[i] , i);
					}
				}
				else
				{
					String playerID = split[location.get(Constants.playerID)];
					Integer birthYear = split[location.get(Constants.birthYear)].isEmpty() ? -1 : Integer.valueOf(location.get(Constants.birthYear));
					Integer birthMonth = split[location.get(Constants.birthMonth)].isEmpty() ? -1 : Integer.valueOf(split[location.get(Constants.birthMonth)]);
					Integer birthDay = split[location.get(Constants.birthDay)].isEmpty() ? -1 : Integer.valueOf(split[location.get(Constants.birthDay)]);
					String birthCountry = split[location.get(Constants.birthCountry)];
					String birthState = split[location.get(Constants.birthState)];
					String birthCity = split[location.get(Constants.birthCity)];
					Integer deathYear = split[location.get(Constants.deathYear)].isEmpty() ? -1 : Integer.valueOf(split[location.get(Constants.deathYear)]);
					Integer deathMonth = split[location.get(Constants.deathMonth)].isEmpty() ? -1 : Integer.valueOf(split[location.get(Constants.deathMonth)]);
					Integer deathDay = split[location.get(Constants.deathDay)].isEmpty() ? -1 : Integer.valueOf(split[location.get(Constants.deathDay)]);
					String deathCountry = split[location.get(Constants.deathCountry)];
					String deathState = split[location.get(Constants.deathState)];
					String deathCity = split[location.get(Constants.birthCity)];
					String nameFirst = split[location.get(Constants.nameFirst)];
					String nameLast = split[location.get(Constants.nameLast)];
					String nameGiven = split[location.get(Constants.nameGiven)];

					Integer weight;
					Integer height;
					String bats;
					String throwes;
					Date debut;
					Date finalGame;
					String retroID;
					String bbrefID;
					if (split.length > 16)
					{
						weight    = split[location.get(Constants.weight)].isEmpty() ? -1 : Integer.valueOf(split[location.get(Constants.weight)]);
						height    = split[location.get(Constants.height)].isEmpty() ? -1 : Integer.valueOf(split[location.get(Constants.height)]);
						bats      = split[location.get(Constants.bats)];
						throwes   = split[location.get(Constants.throwes)];
						debut     = split[location.get(Constants.debut)].isEmpty() ? new Date(Long.MIN_VALUE) : Date.valueOf(split[location.get(Constants.debut)]);
						finalGame = split[location.get(Constants.finalGame)].isEmpty() ? new Date(Long.MIN_VALUE) : Date.valueOf(split[location.get(Constants.finalGame)]);
						retroID   = split[location.get(Constants.retroID)];
						bbrefID   = split[location.get(Constants.bbrefID)];
					}
					else
					{
						weight    = -1;
						height    = -1;
						bats      = "";
						throwes   = "";
						debut     = new Date(Long.MIN_VALUE);
						finalGame = new Date(Long.MIN_VALUE);
						retroID = "";
						bbrefID = "";

					}
					DB.put(split[0], new PlayerDTO(playerID, birthYear, birthMonth, birthDay, birthCountry, birthState,
							birthCity, deathYear, deathMonth, deathDay, deathCountry, deathState, deathCity, nameFirst,
							nameLast, nameGiven, weight, height, bats, throwes, debut, finalGame, retroID, bbrefID));

				}
				lineNumber++;
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		now = LocalDateTime.now();
		System.out.println("end " + dtf.format(now));
		return DB;
	}
}
