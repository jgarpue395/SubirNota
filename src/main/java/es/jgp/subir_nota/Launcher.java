package es.jgp.subir_nota;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.jgp.subir_nota.read_json.ReadJosnEvents;
import es.jgp.subir_nota.utils.JsonException;
import es.jgp.subir_nota.write_json.WriteJson;

/**
 * @author Jesus Garcia Puerto
 * @since 10/01/2023
 * @version 1.0.0
 */
public class Launcher
{
	// logger
	private static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args)
	{
		try
		{
			// instance of ReadJosnEvents
			ReadJosnEvents readJosnEvents = new ReadJosnEvents();
			// call to the method readJson of the class readJosnEvents
			readJosnEvents.readJson();
			// instance of WriteJsonEvent
			WriteJson writeJsonEvent = new WriteJson(readJosnEvents.getEventList());
			// call to the method readJson of the class start
			writeJsonEvent.start();

			LOGGER.info("OK");
		}
		catch (JsonException jsonException)
		{
			jsonException.printStackTrace();
		}
	}
}
