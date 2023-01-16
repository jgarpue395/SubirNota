package es.jgp.subir_nota.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Garcia Puerto
 * @since  12/01/2023
 * @version 1.0.0
 */
public class Jugada2
{
	@JsonProperty("action")
	private String action;
	@JsonProperty("location")
	private List<Double> location;
	public Jugada2(String action, List<Double> location)
	{
		this.action = action;
		this.location = location;
	}
	
	public String getAction()
	{
		return this.action;
	}
	public void setAction(String action)
	{
		this.action = action;
	}
	public List<Double> getLocation()
	{
		return this.location;
	}
	public void setLocation(List<Double> location)
	{
		this.location = location;
	}
}
