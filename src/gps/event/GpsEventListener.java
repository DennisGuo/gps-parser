package gps.event;

/*
 * Copyright 2012 Edmundo Carmona Antoranz
 * All rights reserved
 */

/**
 * Listeners for events have to implement this in order to get feedback about
 * events found by GpsAnalyzer
 * 
 * @author antoranz
 * 
 */
public interface GpsEventListener {
	
	/**
	 * Process this event found by GpsAnalyzer
	 * @param event
	 */
	public void eventFound(AbstractEvent event);

}