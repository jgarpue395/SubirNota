package es.jgp.subir_nota.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Garcia Puerto
 * @since 12/01/2023
 * @version 1.0.0
 */
public class Jugada2
{
	/** Attribute - type of event */
	@JsonProperty("action")
	private String action;

	/** Attribute - location of beginning of the event */
	@JsonProperty("location")
	private List<Double> location;

	/**
	 * Constructor of Jugada2
	 * 
	 * @param action,   type of the event
	 * @param location, location of start of the event
	 */
	public Jugada2(String action, List<Double> location)
	{
		this.action = action;
		this.location = location;
	}

	/**
	 * @return type of event
	 */
	public String getAction()
	{
		return this.action;
	}

	/**
	 * @param action, type of event
	 */
	public void setAction(String action)
	{
		this.action = action;
	}

	/**
	 * @return location of event
	 */
	public List<Double> getLocation()
	{
		return this.location;
	}

	/**
	 * @param location, location of event
	 */
	public void setLocation(List<Double> location)
	{
		this.location = location;
	}
}
