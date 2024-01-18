package com.example.demo.parser;

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
					String playerID = split[location.get("playerID")];
					Integer birthYear = split[location.get("birthYear")].isEmpty() ? -1 : Integer.valueOf(location.get("birthYear"));
					Integer birthMonth = split[location.get("birthMonth")].isEmpty() ? -1 : Integer.valueOf(split[location.get("birthMonth")]);
					Integer birthDay = split[location.get("birthDay")].isEmpty() ? -1 : Integer.valueOf(split[location.get("birthDay")]);
					String birthCountry = split[location.get("birthCountry")];
					String birthState = split[location.get("birthState")];
					String birthCity = split[location.get("birthCity")];
					Integer deathYear = split[location.get("deathYear")].isEmpty() ? -1 : Integer.valueOf(split[location.get("deathYear")]);
					Integer deathMonth = split[location.get("deathMonth")].isEmpty() ? -1 : Integer.valueOf(split[location.get("deathMonth")]);
					Integer deathDay = split[location.get("deathDay")].isEmpty() ? -1 : Integer.valueOf(split[location.get("deathDay")]);
					String deathCountry = split[location.get("deathCountry")];
					String deathState = split[location.get("deathState")];
					String deathCity = split[location.get("deathCity")];
					String nameFirst = split[location.get("nameFirst")];
					String nameLast = split[location.get("nameLast")];
					String nameGiven = split[location.get("nameGiven")];

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
						weight    = split[location.get("weight")].isEmpty() ? -1 : Integer.valueOf(split[location.get("weight")]);
						height    = split[location.get("height")].isEmpty() ? -1 : Integer.valueOf(split[location.get("height")]);
						bats      = split[location.get("bats")];
						throwes   = split[location.get("throws")];
						debut     = split[location.get("debut")].isEmpty() ? new Date(Long.MIN_VALUE) : Date.valueOf(split[location.get("debut")]);
						finalGame = split[location.get("finalGame")].isEmpty() ? new Date(Long.MIN_VALUE) : Date.valueOf(split[location.get("finalGame")]);
						retroID   = split[location.get("retroID")];
						bbrefID   = split[location.get("bbrefID")];
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
