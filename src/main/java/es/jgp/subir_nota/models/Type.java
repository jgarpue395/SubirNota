package es.jgp.subir_nota.models;

/**
 * @author Jesus Garcia Puerto
 * @since 100/01/2023
 * @version 1.0.0
 */
public class Type
{
	// save the name of type of the JSON
	private String name;
	
	/**
	 * Constructor by default
	 */
	public Type()
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
