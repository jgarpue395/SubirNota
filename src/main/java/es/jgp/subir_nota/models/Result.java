package es.jgp.subir_nota.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.nhs.models.resultado.JugadoresInfrautilizados;
import es.nhs.models.resultado.MapaCalor;

public class Result
{
	@JsonProperty("jugadas_verticales")
	private List<JugadasVerticales> jugadasVerticales;

	@JsonProperty("jugador_vertical")
	private List<JugadorVertical> jugadorVertical;
	
	@JsonProperty("mapa_calor")
	private List<MapaCalor> mapaCalor;

	@JsonProperty("jugador_infrautilizado")
    private List<JugadoresInfrautilizados> jugadorInfrautilizado;

	public Result()
	{
		this.jugadasVerticales = new ArrayList<JugadasVerticales>();
		this.jugadorVertical = new ArrayList<JugadorVertical>();
		this.mapaCalor = new ArrayList<MapaCalor>();
		this.jugadorInfrautilizado = new ArrayList<JugadoresInfrautilizados>();
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

	public List<MapaCalor> getMapaCalor()
	{
		return this.mapaCalor;
	}

	public void setMapaCalor(List<MapaCalor> mapaCalor)
	{
		this.mapaCalor = mapaCalor;
	}

	public List<JugadoresInfrautilizados> getJugadorInfrautilizado()
	{
		return this.jugadorInfrautilizado;
	}

	public void setJugadorInfrautilizado(List<JugadoresInfrautilizados> jugadorInfrautilizado)
	{
		this.jugadorInfrautilizado = jugadorInfrautilizado;
	}
}
