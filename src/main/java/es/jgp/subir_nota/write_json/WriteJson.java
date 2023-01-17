package es.jgp.subir_nota.write_json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectWriter;

import es.jgp.subir_nota.models.Events;
import es.jgp.subir_nota.models.GoalShot;
import es.jgp.subir_nota.models.Jugada;
import es.jgp.subir_nota.models.Jugada2;
import es.jgp.subir_nota.models.JugadasVerticales;
import es.jgp.subir_nota.models.JugadorVertical;
import es.jgp.subir_nota.models.Result;
import es.jgp.subir_nota.utils.Json;
import es.jgp.subir_nota.utils.JsonException;
import es.nhs.models.resultado.JugadoresInfrautilizados;
import es.nhs.models.resultado.MapaCalor;

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
	private Result results;

	/**
	 * @param eventList, list of events
	 */
	public WriteJson(List<Events> eventList)
	{
		this.eventList = eventList;
		this.results = new Result();
	}

	/**
	 * Method - call other method
	 * 
	 * @throws JsonException
	 */
	public void start() throws JsonException
	{
		this.jugadasVerticales();
		this.jugadoresVerticales();
		this.jugadorInfrautilizado();
		this.mapasDeCalor();
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
				if (event.getPossession() == possession && vertical >= location)
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
						/*
						 * if the list of plays of the JugadaVertical is bigger that 1 add the
						 * JugadaVertical to results
						 */
						if (jugadasVerticales.getJugada().size() > 1)
						{
							this.results.getJugadasVerticales().add(jugadasVerticales);
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

	private void jugadoresVerticales()
	{
		// Attribute - save the possession of the before event
		int possession = 0;
		// Attribute - save the minute of the event
		int minute = 0;
		// Attribute - save the second of the event
		int second = 0;
		// Attribute - save the name of the team of the team that performed the event
		String team = "";
		// Attribute - save the name of the player that performed the event
		String name = "";
		// Attribute - save the location of the before event
		double location = 0;
		// Attribute - list of Plays
		List<Jugada2> jugadaList = null;
		// Attribute - instance of Play
		Jugada2 jugada = null;

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
				if (vertical >= location + 20 && event.getPlayer().getName().equals(name))
				{
					// add the play to the list of plays
					jugadaList.add(jugada);
					// initialize a new play
					jugada = new Jugada2(event.getType().getName(), event.getLocation());
				}
				else
				{
					// save the minute of the event
					minute = event.getMinute();
					// save the second of the event
					second = event.getSecond();
					// save the name of the team that performed the event
					team = event.getPossession_team().getName();
					// save the name of the player
					name = event.getPlayer().getName();

					// add the last play of the before team
					if (jugada != null)
					{
						jugadaList.add(jugada);
					}

					// if isn't the first event
					if (possession != 0)
					{
						// create a new instance of JugadasVerticales
						JugadorVertical jugadorVertical = new JugadorVertical(minute, second, team, name, jugadaList);
						/*
						 * if the list of plays of the JugadaVertical is bigger that 1 add the
						 * JugadorVertical to results
						 */
						if (jugadorVertical.getJugada().size() > 1)
						{
							this.results.getJugadorVertical().add(jugadorVertical);
						}
					}

					// new instance of jugadaList
					jugadaList = new ArrayList<Jugada2>();
					// new instance of play
					jugada = new Jugada2(event.getType().getName(), event.getLocation());
				}

				// save the location
				location = vertical;
				// save the possession
				possession = event.getPossession();
			}
		}
	}

	private void mapasDeCalor()
	{
		Map<String, MapaCalor> mapaCalorMap = new HashMap<String, MapaCalor>();
		for (Events event : this.eventList)
		{
			if (event.getPlayer() != null && event.getLocation() != null)
			{
				if (!mapaCalorMap.containsKey(event.getPlayer().getName()))
				{
					mapaCalorMap.put(event.getPlayer().getName(), new MapaCalor(event.getPossession_team().getName(),
							event.getPlayer().getName(), new ArrayList<List<Double>>()));
					mapaCalorMap.get(event.getPlayer().getName()).getJugada().add(event.getLocation());
				}
				else
				{
					mapaCalorMap.get(event.getPlayer().getName()).getJugada().add(event.getLocation());
				}
			}
		}

		for (Map.Entry<String, MapaCalor> entry : mapaCalorMap.entrySet())
		{
			this.results.getMapaCalor().add(new MapaCalor(entry.getValue().getTeam(),
					entry.getValue().getPlayer_name(), entry.getValue().getJugada()));
		}
	}

	private void jugadorInfrautilizado()
	{
		Map<String, GoalShot> jugadoresGoleadores = new HashMap<String, GoalShot>();
		for (Events event : this.eventList)
		{
			if (event.getShot() != null)
			{
				if (!jugadoresGoleadores.containsKey(event.getPlayer().getName()))
				{
					if (event.getShot().getOutcome().getName().equalsIgnoreCase("Goal"))
					{
						jugadoresGoleadores.put(event.getPlayer().getName(),
								new GoalShot(1, 1, event.getPossession_team().getName()));
					}
					else
					{
						jugadoresGoleadores.put(event.getPlayer().getName(),
								new GoalShot(1, 0, event.getPossession_team().getName()));
					}
				}
				else
				{
					if (event.getShot().getOutcome().getName().equalsIgnoreCase("Goal"))
					{
						jugadoresGoleadores.get(event.getPlayer().getName())
								.setShot(jugadoresGoleadores.get(event.getPlayer().getName()).getShot() + 1);
						jugadoresGoleadores.get(event.getPlayer().getName())
								.setGoal(jugadoresGoleadores.get(event.getPlayer().getName()).getGoal() + 1);
					}
					else
					{
						jugadoresGoleadores.get(event.getPlayer().getName())
								.setShot(jugadoresGoleadores.get(event.getPlayer().getName()).getShot() + 1);
					}
				}
			}
		}

		for (Map.Entry<String, GoalShot> entry : jugadoresGoleadores.entrySet())
		{
			if ((entry.getValue().getGoal() * 100) / entry.getValue().getShot() >= 33)
			{
				this.results.getJugadorInfrautilizado()
						.add(new JugadoresInfrautilizados(entry.getValue().getTeam(), entry.getKey(),
								entry.getValue().getShot(), entry.getValue().getGoal(),
								(entry.getValue().getGoal() * 100) / entry.getValue().getShot()));
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
			writer.writeValue(new File("estadisticas.json"), this.results);
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
