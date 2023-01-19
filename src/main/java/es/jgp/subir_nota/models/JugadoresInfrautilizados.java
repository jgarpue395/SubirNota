package es.jgp.subir_nota.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Garcia Puerto
 * @version 1.0.0
 * @since 09/01/2023
 */
public class JugadoresInfrautilizados
{
	/** Attribute - name of the team */
	private String team;

	/** Attribute - name of the player */
	@JsonProperty(value = "player_name")
	private String playerName;

	/** Attribute - number of shots */
	@JsonProperty(value = "tiros")
	private int tiros;

	/** Attribute - number of goals */
	@JsonProperty(value = "goles")
	private int goles;

	/** Attribute - percentage of effectiveness */
	@JsonProperty(value = "efectividad")
	private int efectividad;

	/**
	 * Constructor of JugadoresInfrautilizados
	 * 
	 * @param team,        name of the team
	 * @param player_name, name of the player
	 * @param tiros,       number of shots
	 * @param goles,       number of goals
	 * @param efectividad, percentage of effectiveness
	 */
	public JugadoresInfrautilizados(String team, String player_name, int tiros, int goles, int efectividad)
	{
		this.team = team;
		this.playerName = player_name;
		this.tiros = tiros;
		this.goles = goles;
		this.efectividad = efectividad;
	}

	/**
	 * @return the name of the team
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
	 * @return number of shots
	 */
	public int getTiros()
	{
		return this.tiros;
	}

	/**
	 * @param tiros, number of shots
	 */
	public void setTiros(int tiros)
	{
		this.tiros = tiros;
	}

	/**
	 * @return number of goals
	 */
	public int getGoles()
	{
		return this.goles;
	}

	/**
	 * @param goles, number of goals
	 */
	public void setGoles(int goles)
	{
		this.goles = goles;
	}

	/**
	 * @return the percentage of effectiveness
	 */
	public int getEfectividad()
	{
		return this.efectividad;
	}

	/**
	 * @param efectividad, percentage of effectiveness
	 */
	public void setEfectividad(int efectividad)
	{
		this.efectividad = efectividad;
	}
}
