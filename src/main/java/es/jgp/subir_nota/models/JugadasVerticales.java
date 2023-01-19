package es.jgp.subir_nota.models;

import java.util.List;

/**
 * @author Jesus Garcia Puerto
 * @since 10/01/2023
 * @version 1.0.0
 */
public class JugadasVerticales
{
	/** Attribute - minute of beginning of the event */
	private int minute;

	/** Attribute - second of beginning of the event */
	private int second;

	/** Attribute - team that performed the event */
	private String team;

	/** Attribute - list of Jugada */
	private List<Jugada> jugada;

	/**
	 * Constructor of JugadasVerticales
	 * 
	 * @param minute, minute of beginning of the event
	 * @param second, second of beginning of the event
	 * @param team,   team that performed the event
	 * @param jugada, list of Jugada
	 */
	public JugadasVerticales(int minute, int second, String team, List<Jugada> jugada)
	{
		this.minute = minute;
		this.second = second;
		this.team = team;
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
	 * @return list of Jugada
	 */
	public List<Jugada> getJugada()
	{
		return this.jugada;
	}

	/**
	 * @param jugada, list of Jugada
	 */
	public void setJugada(List<Jugada> jugada)
	{
		this.jugada = jugada;
	}
}
