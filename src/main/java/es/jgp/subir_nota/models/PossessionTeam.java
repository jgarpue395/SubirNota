package es.jgp.subir_nota.models;

/**
 * @author Jesus Garcia Puerto
 * @since 100/01/2023
 * @version 1.0.0
 */
public class PossessionTeam
{
	// save the value of name of possessions_team of JSON
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
