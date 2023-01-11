package es.jgp.subir_nota.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Garcia Puerto
 * @since 10/01/2023
 * @version 1.0.0
 */
public class Jugada
{
	@JsonProperty("player_name")
	private String playerName;
	private String action;
	private List<Double> location;
	
	public Jugada(String playerName, String action, List<Double> location)
	{
		this.playerName = playerName;
		this.action = action;
		this.location = location;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public List<Double> getLocation()
	{
		return location;
	}

	public void setLocation(List<Double> location)
	{
		this.location = location;
	}
}
