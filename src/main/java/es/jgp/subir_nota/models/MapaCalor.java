package es.jgp.subir_nota.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Garcia Puerto
 * @version 1.0.0
 * @since 16/01/2023
 */
public class MapaCalor
{
	/** Attribute - name of the team */
	private String team;

	/** Attribute - name of the player */
	@JsonProperty(value = "player_name")
	private String playerName;

	/** Attribute - list of locations */
	@JsonProperty(value = "jugada")
	private List<List<Double>> jugada;

	/**
	 * Constructor of MapaCalor
	 * 
	 * @param team,       name of the team
	 * @param playerName, name of the player
	 * @param jugada,     list of location
	 */
	public MapaCalor(String team, String playerName, List<List<Double>> jugada)
	{
		this.team = team;
		this.playerName = playerName;
		this.jugada = jugada;
	}

	/**
	 * @return name of the team
	 */
	public String getTeam()
	{
		return this.team;
	}

	/**
	 * @param team, name of the team
	 */
	public void setTeam(String team)
	{
		this.team = team;
	}

	/**
	 * @return the name of the player
	 */
	public String getPlayerName()
	{
		return this.playerName;
	}

	/**
	 * @param playerName, name of the player
	 */
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	/**
	 * @return list of locations
	 */
	public List<List<Double>> getJugada()
	{
		return this.jugada;
	}

	/**
	 * @param jugada, list of locations
	 */
	public void setJugada(List<List<Double>> jugada)
	{
		this.jugada = jugada;
	}
}
