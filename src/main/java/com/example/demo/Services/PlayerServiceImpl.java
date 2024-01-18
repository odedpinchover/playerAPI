package com.example.demo.Services;

import com.example.demo.DTOs.PlayerDTO;
import com.example.demo.exceptions.ElementNotFoundException;
import com.example.demo.parser.PlayerParser;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Map;

@Service
public class PlayerServiceImpl implements IPlayerService
{

	private static Map<String, PlayerDTO> DB;
	static {
		DB = PlayerParser.parsePlayerFile("player.csv");
	}

	@Override
	public PlayerDTO getPlayerByID(String playerID) throws Exception
	{
		if (DB.containsKey(playerID))
		{
			return DB.get(playerID);
		}
		else
		{
			throw new ElementNotFoundException();
//			throw new Exception("exception of type that is not yet handled");
		}
	}

	@Override
	public Collection<PlayerDTO> getAllPlayers()
	{
		return DB.values();
	}
}
