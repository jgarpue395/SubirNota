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
import es.jgp.subir_nota.models.Jugada2;
import es.jgp.subir_nota.models.JugadasVerticales;
import es.jgp.subir_nota.models.JugadorVertical;
import es.jgp.subir_nota.models.JugadoresInfrautilizados;
import es.jgp.subir_nota.models.MapaCalor;
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
				/*
				 * check if the possession of 2 events is same and if the location of the event
				 * is bigger that the location of the before event in 20
				 */
				if (event.getPlayer().getName().equals(name))
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
						int size = jugadaList.size() - 1;
						
						// check if the player toured a distance of 20
						if (jugadaList.get(size).getLocation().get(0) - jugadaList.get(0).getLocation().get(0) >= 20)
						{
							// create a new instance of JugadasVerticales
							JugadorVertical jugadorVertical = new JugadorVertical(minute, second, team, name,
									jugadaList);

							/*
							 * if the list of plays of the JugadaVertical is bigger that 1 add the
							 * JugadorVertical to results
							 */
							if (jugadorVertical.getJugada().size() > 1)
							{
								this.results.getJugadorVertical().add(jugadorVertical);
							}
						}
					}

					// new instance of jugadaList
					jugadaList = new ArrayList<Jugada2>();
					// new instance of play
					jugada = new Jugada2(event.getType().getName(), event.getLocation());
				}

				// save the possession
				possession = event.getPossession();
			}
		}
	}

	/**
	 * Method - save all the locations of the events related to each player
	 */
	private void mapasDeCalor()
	{
		// List of name of player
		List<String> nameList = new ArrayList<String>();

		// tour the list of events
		for (Events event : this.eventList)
		{
			// list of location
			List<List<Double>> locationList = new ArrayList<List<Double>>();

			// check is the player and location of the event aren't null
			if (event.getPlayer() != null && event.getLocation() != null)
			{
				// save the name of the player
				String player = event.getPlayer().getName();
				// save the name of the team
				String team = event.getPossession_team().getName();

				// check if the player's location has been saved
				if (!nameList.contains(player))
				{
					// add the player to the list of name
					nameList.add(player);

					// tour the list of events
					for (Events event2 : this.eventList)
					{
						// check is the player and location of the event aren't null
						if (event2.getPlayer() != null && event2.getLocation() != null)
						{
							// check all locations of a player
							if (player.equals(event2.getPlayer().getName()))
							{
								// add the location to locationList of a player
								locationList.add(event2.getLocation());
							}
						}
					}

					// instance of MapaCalor
					MapaCalor mapaCalor = new MapaCalor(team, player, locationList);

					// add the mapaCalor to results
					this.results.getMapaCalor().add(mapaCalor);
				}
			}
		}
	}

	/**
	 * Method - Find the player who score and goal and its hit rate is grater than
	 * 33%
	 */
	private void jugadorInfrautilizado()
	{
		// List of name of player
		List<String> nameList = new ArrayList<String>();

		// Tour the list of events
		for (Events event : this.eventList)
		{
			// count of shots
			int shots = 0;
			// count of goals
			int goals = 0;

			// check that player isn't null
			if (event.getPlayer() != null)
			{
				// save the name of player
				String player = event.getPlayer().getName();
				// save the name of team
				String team = event.getPossession_team().getName();

				// checks if the player's shots have been counted
				if (!nameList.contains(player))
				{
					// add the player to the list of names
					nameList.add(event.getPlayer().getName());

					// tour all event
					for (int i = 0; i < this.eventList.size(); i++)
					{
						// check that player isn't null
						if (this.eventList.get(i).getPlayer() != null)
						{
							/*
							 * check if that the name of player of the event is the name of player whose
							 * shots I am counting
							 */
							if (player.equals(this.eventList.get(i).getPlayer().getName()))
							{
								// check if the event is a shot
								if (this.eventList.get(i).getShot() != null)
								{
									// add 1 to shots
									shots++;
									// check that outcome isn't null
									if (this.eventList.get(i).getShot().getOutcome() != null)
									{
										// check if the shot is a goal
										if (this.eventList.get(i).getShot().getOutcome().getName().equals("Goal"))
										{
											// add 1 to goals
											goals++;
										}
									}
								}
							}
						}
					}

					// check that the player has more of 0 shots and more of 0 goals
					if (shots > 0 && goals > 0)
					{
						// calculate the effectiveness of the player
						double effectiveness = ((double) goals / (double) shots) * 100;
						// check if effectiveness is greater that 33%
						if (effectiveness >= 33)
						{
							// Instance of JugadoresInfrautilizados
							JugadoresInfrautilizados jugadoresInfrautilizados = new JugadoresInfrautilizados(team,
									player, shots, goals, (int) effectiveness);
							// add jugadoresInfrautilizados to results
							this.results.getJugadorInfrautilizado().add(jugadoresInfrautilizados);
						}
					}
				}
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
