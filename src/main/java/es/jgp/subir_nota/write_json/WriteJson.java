package es.jgp.subir_nota.write_json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectWriter;

import es.jgp.subir_nota.models.Events;
import es.jgp.subir_nota.models.Jugada;
import es.jgp.subir_nota.models.JugadasVerticales;
import es.jgp.subir_nota.models.Result;
import es.jgp.subir_nota.utils.Json;
import es.jgp.subir_nota.utils.JsonException;

/**
 * @author Jesus Garcia Puerto
 * @since 10/01/2023
 * @version 1.0.0
 */
public class WriteJson
{
	// logger
	private final Logger LOGGER = LogManager.getLogger();

	// List of Event
	private List<Events> eventList;

	// List of Result
	private List<Result> resultsList;

	/**
	 * @param eventList, list of events
	 */
	public WriteJson(List<Events> eventList)
	{
		this.eventList = eventList;
		this.resultsList = new ArrayList<Result>();
	}

	/**
	 * Method - call other method
	 * 
	 * @throws JsonException
	 */
	public void start() throws JsonException
	{
		this.jugadasVerticales();
		this.write();
	}

	/**
	 * Method - tour the list of events and check if the several events are the same
	 * team and if between events have advanced the location in 20
	 */
	private void jugadasVerticales()
	{
		// Attribute - save the possession of the before event
		int possession = 0;
		// Attribute - save the minute of the event
		int minute = 0;
		// Attribute - save the second of the event
		int second = 0;
		// Attribute - save the name of the team of the team that performed the event
		String name = "";
		// Attribute - save the location of the before event
		double location = 0;
		// Attribute - list of Plays
		List<Jugada> jugadaList = null;
		// Attribute - instance of Play
		Jugada jugada = null;

		// tour the list of events
		for (Events event : this.eventList)
		{
			// check if the event has Location and a Player
			if (event.getLocation() != null && event.getPlayer() != null)
			{
				// Attribute - save the Location of the event
				double vertical = event.getLocation().get(0);

				/*
				 * check if the possession of 2 events is same and if the location of the event
				 * is bigger that the location of the before event in 20
				 */
				if (event.getPossession() == possession && vertical > location + 20)
				{
					// add the play to the list of plays
					jugadaList.add(jugada);
					// initialize a new play
					jugada = new Jugada(event.getPlayer().getName(), event.getType().getName(), event.getLocation());
				}
				else
				{
					// save the minute of the event
					minute = event.getMinute();
					// save the second of the event
					second = event.getSecond();
					// save the name of the team that performed the event
					name = event.getPossession_team().getName();
					
					// add the last play of the before team
					if (jugada != null)
					{
						jugadaList.add(jugada);
					}
					
					// if isn't the first event 
					if (possession != 0)
					{
						// create a new instance of JugadasVerticales
						JugadasVerticales jugadasVerticales = new JugadasVerticales(minute, second, name, jugadaList);
						// if the list of plays of the JugadaVertical is bigger that 1 add the JugadaVertical to results
						if (jugadasVerticales.getJugada().size() > 1)
						{
							this.resultsList.add(new Result(jugadasVerticales));
						}
					}

					// new instance of jugadaList
					jugadaList = new ArrayList<Jugada>();
					// new instance of play
					jugada = new Jugada(event.getPlayer().getName(), event.getType().getName(), event.getLocation());
				}

				// save the location
				location = vertical;
				// save the possession
				possession = event.getPossession();
			}
		}
	}

	private void write() throws JsonException
	{
		// instance of the class ObjectWriter used the mapper of the class Json
		ObjectWriter writer = Json.mapper().writer(new DefaultPrettyPrinter());

		try
		{
			// write the content of the list in a new JSON
			writer.writeValue(new File("estadisticas.json"), this.resultsList);
		}
		catch (StreamWriteException streamWriteException)
		{
			LOGGER.error("Error to write JSON:" + streamWriteException);
			throw new JsonException("Error to write JSON:" + streamWriteException);
		}
		catch (DatabindException databindException)
		{
			LOGGER.error("Error to convert JSON to object:" + databindException);
			throw new JsonException("Error to convert object to JSON:" + databindException);
		}
		catch (IOException ioException)
		{
			LOGGER.error("Error to write JSON:" + ioException);
			throw new JsonException("Error to write JSON:" + ioException);
		}
	}
}
