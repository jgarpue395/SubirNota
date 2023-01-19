package es.jgp.subir_nota.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Garcia Puerto
 * @since 10/01/2023
 * @version 1.0.0
 */
public class Events
{
	/** Attribute - minute in that it is performed the event */
	private int minute;

	/** Attribute - second in that it is performed the event */
	private int second;

	/** Attribute - info of the player that performed the event */
	private Player player;

	/** Attribute - possession of event */
	private int possession;

	/** Attribute - team that has the possession in the event */
	@JsonProperty(value = "possession_team")
	private PossessionTeam possessionTeam;

	/** Attribute - type of event */
	private Type type;

	/** Attribute - location of the player who performed the event */
	private List<Double> location;
	/** Attribute - info of a shot */
	private Shot shot;

	/**
	 * Constructor by default
	 */
	public Events()
	{
		// empty constructor
	}

	/**
	 * @return the minute in that it is performed the event
	 */
	public int getMinute()
	{
		return this.minute;
	}

	/**
	 * @param minute, minute in that it is performed the event
	 */
	public void setMinute(int minute)
	{
		this.minute = minute;
	}

	/**
	 * @return the second in that it is performed the event
	 */
	public int getSecond()
	{
		return this.second;
	}

	/**
	 * @param second, second in that it is performed the event
	 */
	public void setSecond(int second)
	{
		this.second = second;
	}

	/**
	 * @return the player who performed the event
	 */
	public Player getPlayer()
	{
		return this.player;
	}

	/**
	 * @param player, player who performed the event
	 */
	public void setPlayer(Player player)
	{
		this.player = player;
	}

	/**
	 * @return the possession of event
	 */
	public int getPossession()
	{
		return possession;
	}

	/**
	 * @param possession, possession of event
	 */
	public void setPossession(int possession)
	{
		this.possession = possession;
	}

	/**
	 * @return the info of the team who had the possession
	 */
	public PossessionTeam getPossession_team()
	{
		return this.possessionTeam;
	}

	/**
	 * @param possession_team, info of the team who had the possession
	 */
	public void setPossessionTeam(PossessionTeam possessionTeam)
	{
		this.possessionTeam = possessionTeam;
	}

	/**
	 * @return the type of event
	 */
	public Type getType()
	{
		return this.type;
	}

	/**
	 * @param type, type of event
	 */
	public void setType(Type type)
	{
		this.type = type;
	}

	/**
	 * @return a list with the location of the player
	 */
	public List<Double> getLocation()
	{
		return this.location;
	}

	/**
	 * @param location, list with the location of the player
	 */
	public void setLocation(List<Double> location)
	{
		this.location = location;
	}

	/**
	 * @return the info a shot
	 */
	public Shot getShot()
	{
		return this.shot;
	}

	/**
	 * @param shot, info of a shot
	 */
	public void setShot(Shot shot)
	{
		this.shot = shot;
	}
}
