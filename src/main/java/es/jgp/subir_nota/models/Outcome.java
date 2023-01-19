package es.jgp.subir_nota.models;

/**
 * @author Jesus Garcia Puerto
 * @since 16/01/2023
 * @version 1.0.0
 */
public class Outcome
{
	/** Attribute - name of outcome */
	private String name;

	/**
	 * Constructor by default
	 */
	public Outcome()
	{

	}

	/**
	 * @return the name of the outcome
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name, name of the outcome
	 */
	public void setName(String name)
	{
		this.name = name;
	}
}
