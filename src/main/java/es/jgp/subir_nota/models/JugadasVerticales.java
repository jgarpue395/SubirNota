package es.jgp.subir_nota.models;

import java.util.List;

/**
 * @author Jesus Garcia Puerto
 * @since 10/01/2023
 * @version 1.0.0
 */
public class JugadasVerticales
{
	private int minute;
	private int second;
	private String team;
	private List<Jugada> jugada;
	
	public JugadasVerticales(int minute, int second, String team, List<Jugada> jugada)
	{
		this.minute = minute;
		this.second = second;
		this.team = team;
		this.jugada = jugada;
	}

	public int getMinute()
	{
		return this.minute;
	}

	public void setMinute(int minute)
	{
		this.minute = minute;
	}

	public int getSecond()
	{
		return this.second;
	}

	public void setSecond(int second)
	{
		this.second = second;
	}

	public String getTeam()
	{
		return this.team;
	}

	public void setTeam(String team)
	{
		this.team = team;
	}

	public List<Jugada> getJugada()
	{
		return this.jugada;
	}

	public void setJugada(List<Jugada> jugada)
	{
		this.jugada = jugada;
	}
}
