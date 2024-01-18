package com.example.demo.Services;

import com.example.demo.DTOs.PlayerDTO;

import java.util.Collection;
import java.util.List;

public interface IPlayerService
{
	/**
	 *
	 *
	 * @param playerID
	 * @return
	 * @throws Exception
	 */
	public PlayerDTO getPlayerByID(String playerID) throws Exception;
	public Collection<PlayerDTO> getAllPlayers();
}
