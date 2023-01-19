package es.jgp.subir_nota.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Garcia Puerto
 * @since 12/01/2023
 * @version 1.0.0
 */
public class JugadorVertical
{
	/** Attribute - minute of beginning of the event */
	private int minute;

	/** Attribute - second of beginning of the event */
	private int second;

	/** Attribute - team that performed the event */
	private String team;

	/** Attribute - name of the player */
	@JsonProperty(value = "player_name")
	private String playerName;

	/** Attribute - list of Jugada2 */
	private List<Jugada2> jugada;

	/**
	 * Constructor of JugadorVertical
	 * 
	 * @param minute,     minute of beginning of the event
	 * @param second,     second of beginning of the event
	 * @param team,       team that performed the event
	 * @param playerName, name of the player
	 * @param jugada,     list of Jugada2
	 */
	public JugadorVertical(int minute, int second, String team, String playerName, List<Jugada2> jugada)
	{
		this.minute = minute;
		this.second = second;
		this.team = team;
		this.playerName = playerName;
		this.jugada = jugada;
	}

	/**
	 * @return minute of beginning of the event
	 */
	public int getMinute()
	{
		return this.minute;
	}

	/**
	 * @param minute, minute of beginning of the event
	 */
	public void setMinute(int minute)
	{
		this.minute = minute;
	}

	/**
	 * @return second of beginning of the event
	 */
	public int getSecond()
	{
		return this.second;
	}

	/**
	 * @param second, second of beginning of the event
	 */
	public void setSecond(int second)
	{
		this.second = second;
	}

	/**
	 * @return team that performed the event
	 */
	public String getTeam()
	{
		return this.team;
	}

	/**
	 * @param team, team that performed the event
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
	 * @return list of Jugada2
	 */
	public List<Jugada2> getJugada()
	{
		return this.jugada;
	}

	/**
	 * @param jugada, list of Jugada2
	 */
	public void setJugada(List<Jugada2> jugada)
	{
		this.jugada = jugada;
	}
}
