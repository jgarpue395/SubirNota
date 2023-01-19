package es.jgp.subir_nota.models;

/**
 * @author Jesus Garcia Puerto
 * @since 10/01/2023
 * @version 1.0.0
 */
public class Shot
{
	/** Attribute - info of outcome of the event */
	private Outcome outcome;

	/**
	 * Constructor by default
	 */
	public Shot()
	{

	}

	/**
	 * @return info of outcome of the event
	 */
	public Outcome getOutcome()
	{
		return this.outcome;
	}

	/**
	 * @param outcome, info of outcome of the event
	 */
	public void setOutcome(Outcome outcome)
	{
		this.outcome = outcome;
	}
}
