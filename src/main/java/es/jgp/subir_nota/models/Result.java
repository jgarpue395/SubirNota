package es.jgp.subir_nota.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result
{
	@JsonProperty("jugadas_verticales")
	private List<JugadasVerticales> jugadasVerticales;

	@JsonProperty("jugador_vertical")
	private List<JugadorVertical> jugadorVertical;

	public Result()
	{
		this.jugadasVerticales = new ArrayList<JugadasVerticales>();
		this.jugadorVertical = new ArrayList<JugadorVertical>();
	}

	public List<JugadasVerticales> getJugadasVerticales()
	{
		return this.jugadasVerticales;
	}

	public void setJugadasVerticales(List<JugadasVerticales> jugadasVerticales)
	{
		this.jugadasVerticales = jugadasVerticales;
	}

	public List<JugadorVertical> getJugadorVertical()
	{
		return this.jugadorVertical;
	}

	public void setJugadorVertical(List<JugadorVertical> jugadorVertical)
	{
		this.jugadorVertical = jugadorVertical;
	}
}
