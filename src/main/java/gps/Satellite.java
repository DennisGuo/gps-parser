package gps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


/*
 * Copyright 2012 Edmundo Carmona Antoranz
 * All rights reserved
 * Released under the terms of Mozilla Public License 2.0
 */

/**
 * Information about a satellite
 * 
 * @author antoranz
 * 
 */
public class Satellite {

	private static Logger log = LoggerFactory.getLogger(Satellite.class);

	private int prn;
	private int elevation;
	private int azimuth;
	private int snr;
	private boolean inView;
	private Date lastUpdate;

	/**
	 * 
	 * @param pnr
	 * @param elevation
	 * @param azimuth
	 * @param snr
	 *            Signal-to-Noise reduction. Values between 0-100. -1 means
	 *            there's not signal
	 */
	public Satellite(int prn, int elevation, int azimuth, int snr,
			boolean inView) {
		log.debug("Creating satellite " + prn);
		this.prn = prn;
		this.elevation = elevation;
		this.azimuth = azimuth;
		this.snr = snr;
		this.inView = inView;
		this.lastUpdate = new Date();
	}

	public void refresh(int elevation, int azimuth, int snr, boolean inView) {
		log.debug("Updating satellite " + prn);
		this.elevation = elevation;
		this.azimuth = azimuth;
		this.snr = snr;
		this.inView = inView;
		this.lastUpdate = new Date();
	}
	
	public int getPRN() {
		return this.prn;
	}

	public boolean isInView() {
		return inView;
	}

	/**
	 * set the satellite to not in view. Don't refresh last update date
	 */
	public void setNotInView() {
		log.debug("Setting satellite " + prn + " as not in view");
		this.inView = false;
	}

}
