package gps.event.records;


/*
 * Copyright 2012 Edmundo Carmona Antoranz
 * All rights reserved
 * Released under the terms of Mozilla Public License 2.0
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GPGLL extends GpsInfoRecord {

	private static Logger log = LoggerFactory.getLogger(GPGLL.class);

	protected GPGLL(String[] fields) {
		super(fields);
		log.debug("GPGLL Geographic Latitude and Longitude");
	}

}
