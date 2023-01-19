package es.jgp.subir_nota.models;

/**
 * @author Jesus Garcia Puerto
 * @since 10/01/2023
 * @version 1.0.0
 */
public class Player
{
	// save the name of a player
	private String name;

	/**
	 * Constructor by default
	 */
	public Player()
	{
		// empty constructor
	}

	/**
	 * @return the name of the player
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name, name of a player
	 */
	public void setName(String name)
	{
		this.name = name;
	}
}
