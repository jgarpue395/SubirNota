package es.jgp.subir_nota.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Garcia Puerto
 * @since 10/01/2023
 * @version 1.0.0
 */
public class Result
{
	/** Attribute - List of JugadasVerticales */
	@JsonProperty("jugadas_verticales")
	private List<JugadasVerticales> jugadasVerticales;

	/** Attribute - List of JugadorVertical */
	@JsonProperty("jugador_vertical")
	private List<JugadorVertical> jugadorVertical;

	/** Attribute - List of MapaCalor */
	@JsonProperty("mapa_calor")
	private List<MapaCalor> mapaCalor;

	/** Attribute - List of JugadoresInfrautilizados */
	@JsonProperty("jugador_infrautilizado")
	private List<JugadoresInfrautilizados> jugadorInfrautilizado;

	/**
	 * Constructor by default
	 */
	public Result()
	{
		this.jugadasVerticales = new ArrayList<JugadasVerticales>();
		this.jugadorVertical = new ArrayList<JugadorVertical>();
		this.mapaCalor = new ArrayList<MapaCalor>();
		this.jugadorInfrautilizado = new ArrayList<JugadoresInfrautilizados>();
	}

	/**
	 * @return a list of JugadasVerticales
	 */
	public List<JugadasVerticales> getJugadasVerticales()
	{
		return this.jugadasVerticales;
	}

	/**
	 * @param jugadasVerticales, list of JugadasVerticales
	 */
	public void setJugadasVerticales(List<JugadasVerticales> jugadasVerticales)
	{
		this.jugadasVerticales = jugadasVerticales;
	}

	/**
	 * @return a list of JugadorVertical
	 */
	public List<JugadorVertical> getJugadorVertical()
	{
		return this.jugadorVertical;
	}

	/**
	 * @param jugadorVertical, list of JugadorVertical
	 */
	public void setJugadorVertical(List<JugadorVertical> jugadorVertical)
	{
		this.jugadorVertical = jugadorVertical;
	}

	/**
	 * @return a list of MapaCalor
	 */
	public List<MapaCalor> getMapaCalor()
	{
		return this.mapaCalor;
	}

	/**
	 * @param mapaCalor, list of MapaCalor
	 */
	public void setMapaCalor(List<MapaCalor> mapaCalor)
	{
		this.mapaCalor = mapaCalor;
	}

	/**
	 * @return a list of JugadoresInfrautilizados
	 */
	public List<JugadoresInfrautilizados> getJugadorInfrautilizado()
	{
		return this.jugadorInfrautilizado;
	}

	/**
	 * @param jugadorInfrautilizado, list of JugadoresInfrautilizados
	 */
	public void setJugadorInfrautilizado(List<JugadoresInfrautilizados> jugadorInfrautilizado)
	{
		this.jugadorInfrautilizado = jugadorInfrautilizado;
	}
}
