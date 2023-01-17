package es.jgp.subir_nota.models;

import java.util.List;

/**
 * @author Jesus Garcia Puerto
 * @since 10/01/2023
 * @version 1.0.0
 */
public class Events
{
	// save the minute in that it is performed the event
	private int minute;
	// save the second in that it is performed the event
	private int second;
	// save the info of the player that performed the event
	private Player player;
	// save the possession of JSON
	private int possession;
	// save the possession_team of JSON
	private PossessionTeam possession_team;
	// save the type of JSON
	private Type type;
	// save the location of the player who performed the event
	private List<Double> location;
	
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
		return this.possession_team;
	}

	/**
	 * @param possession_team, info of the team who had the possession
	 */
	public void setPossession_team(PossessionTeam possession_team)
	{
		this.possession_team = possession_team;
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
	 * @return a array with the location of the player
	 */
	public List<Double> getLocation()
	{
		return this.location;
	}

	/**
	 * @param location, array with the location of the player
	 */
	public void setLocation(List<Double> location)
	{
		this.location = location;
	}

	public Shot getShot()
	{
		return this.shot;
	}

	public void setShot(Shot shot)
	{
		this.shot = shot;
	}
}
