package es.jgp.subir_nota.read_json;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.jgp.subir_nota.models.Events;
import es.jgp.subir_nota.utils.Json;
import es.jgp.subir_nota.utils.JsonException;

/**
 * @author Jesus Garcia Puerto
 * @since 07/12/2022
 * @version 1.0.0
 */
public class ReadJosnEvents
{
	// logger
	private final Logger LOGGER = LogManager.getLogger();

	// Attribute - List of Event
	private List<Events> eventList;

	/**
	 * Method - read the JSON and create a list of Events
	 * 
	 * @throws JsonException
	 */
	public final void readJson() throws JsonException
	{
		try
		{
			// create a instance of ObjectMapper used the mapper of the class Json
			ObjectMapper mapper = Json.mapper();

			// list of Event create used the JSON 3795220_three-sixty.json
			this.eventList = mapper.readValue(Paths.get("3795220_events.json").toFile(),
					new TypeReference<List<Events>>()
					{
					});
		}
		catch (StreamReadException streamReadException)
		{
			LOGGER.error("Error to read JSON:" + streamReadException);
			throw new JsonException("Error to read JSON:" + streamReadException);
		}
		catch (DatabindException databindException)
		{
			LOGGER.error("Error to convert JSON to object:" + databindException);
			throw new JsonException("Error to convert JSON to object:" + databindException);
		}
		catch (IOException ioException)
		{
			LOGGER.error("Error to read JSON:" + ioException);
			throw new JsonException("Error to read JSON:" + ioException);
		}
	}

	/**
	 * @return a list of competition
	 */
	public List<Events> getEventList()
	{
		return this.eventList;
	}
}
