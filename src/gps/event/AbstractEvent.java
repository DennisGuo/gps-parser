package gps.event;


/*
 * Copyright 2012 Edmundo Carmona Antoranz <eantoranz@gmail.com>
 * All rights reserved
 */

/**
 * An event reported by GPS device/log
 * 
 * @author antoranz
 * 
 */
public abstract class AbstractEvent {

	protected String[] fields;

	public static AbstractEvent createEvent(String inputLine)
			throws InvalidInputException {
		if (inputLine.length() == 0) {
			throw new InvalidInputException("Empty input line");

		}
		if (inputLine.charAt(0) != '$') {
			throw new InvalidInputException("Record doesn't start with $");
		}
		int checksumPos = inputLine.indexOf('*');
		if (checksumPos != -1) {
			/*
			 * FIXME has checksum, let's check it.... but, for now, let's just
			 * strip it
			 */
			inputLine = inputLine.substring(0, checksumPos);
		}

		String[] fields = inputLine.substring(1).split(",");
		if (fields[0].equals("GPGGA")) {
			return new GPGGA(fields);
		} else if (fields[0].equals("GPGLL")) {
			return new GPGLL(fields);
		} else if (fields[0].equals("GPGSA")) {
			return new GPGSA(fields);
		} else if (fields[0].equals("GPGSV")) {
			return new GPGSV(fields, inputLine.endsWith(","));
		} else if (fields[0].equals("GPVTG")) {
			return new GPVTG(fields);
		} else if (fields[0].equals("GPRMC")) {
			return new GPRMC(fields);
		} else {
			return new UnknownEvent(fields);
		}
	}

	protected AbstractEvent(String[] fields) {
		this.fields = fields;
	}

}