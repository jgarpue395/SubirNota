package es.jgp.subir_nota.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result
{
	@JsonProperty("jugadas_verticales")
	private JugadasVerticales jugadasVerticales;
	
	public Result(JugadasVerticales jugadasVerticales)
	{
		this.jugadasVerticales = jugadasVerticales;
	}

	public JugadasVerticales getJugadasVerticales()
	{
		return jugadasVerticales;
	}

	public void setJugadasVerticales(JugadasVerticales jugadasVerticales)
	{
		this.jugadasVerticales = jugadasVerticales;
	}
}
