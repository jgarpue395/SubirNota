package es.jgp.subir_nota.models;

/**
 * @author Jesus Garcia Puerto
 * @since 10/01/2023
 * @version 1.0.0
 */
public class PossessionTeam
{
	/** Attribute - name of possessions_team of the event */
	private String name;

	/**
	 * Constructor by default
	 */
	public PossessionTeam()
	{

	}

	// getters and setters
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
