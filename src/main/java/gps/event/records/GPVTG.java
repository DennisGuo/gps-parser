package gps.event.records;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Copyright 2012 Edmundo Carmona Antoranz
 * All rights reserved
 * Released under the terms of Mozilla Public License 2.0
 */
public class GPVTG extends GpsInfoRecord {

	private static Logger log = LoggerFactory.getLogger(GPVTG.class);

	protected GPVTG(String[] fields) {
		super(fields);
		log.debug("GPVTG Vector track and speed over ground");
	}

}
