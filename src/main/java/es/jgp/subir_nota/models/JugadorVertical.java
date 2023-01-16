package es.jgp.subir_nota.models;

import java.util.List;

/**
 * @author Jesus Garcia Puerto
 * @since  12/01/2023
 * @version 1.0.0
 */
public class JugadorVertical
{
	private int minute;
	private int second;
	private String team;
	private String player_name;
	private List<Jugada2> jugada;
	
	public JugadorVertical(int minute, int second, String team, String player_name, List<Jugada2> jugada)
	{
		this.minute = minute;
		this.second = second;
		this.team = team;
		this.player_name = player_name;
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

	public String getPlayer_name()
	{
		return this.player_name;
	}

	public void setPlayer_name(String player_name)
	{
		this.player_name = player_name;
	}

	public List<Jugada2> getJugada()
	{
		return this.jugada;
	}

	public void setJugada(List<Jugada2> jugada)
	{
		this.jugada = jugada;
	}
}
