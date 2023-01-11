package es.jgp.subir_nota.utils;

public class JsonException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5949418165563916680L;

	public JsonException()
	{
		super();
	}
	
	public JsonException(String mensage)
	{
		super(mensage);
	}
	
	public JsonException(String mensage, Exception exception)
	{
		super(mensage, exception);
	}
}
