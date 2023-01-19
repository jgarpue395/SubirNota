package es.jgp.subir_nota.models;

/**
 * @author Jesus Garcia Puerto
 * @since 10/01/2023
 * @version 1.0.0
 */
public class Type
{
	/** Attribute - name of type of the event */
	private String name;

	/**
	 * Constructor by default
	 */
	public Type()
	{

	}

	/**
	 * @return name of type of the event
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name, name of type of the event
	 */
	public void setName(String name)
	{
		this.name = name;
	}
}
