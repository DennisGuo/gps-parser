package gps;

import gps.event.InvalidInputException;
import gps.event.records.GPRMC;
import gps.event.records.GpsInfoRecord;

public class GPRMCReader {

    public static GPRMC read(String source) throws InvalidInputException {
        GpsInfoRecord record  = GpsInfoRecord.createRecord(source);
        return record instanceof GPRMC ? (GPRMC) record : null;
    }
}
