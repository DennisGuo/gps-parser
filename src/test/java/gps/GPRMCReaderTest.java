package gps;

import gps.event.InvalidInputException;
import gps.event.records.GpsInfoRecord;
import org.junit.Test;

import static org.junit.Assert.*;

public class GPRMCReaderTest {

    @Test
    public void read() {
        String source = "$GPRMC,053728.000,A,3959.5238,N,11622.3053,E,0.0,0.0,191118,5.9,W,A*18";
        try {
            GpsInfoRecord record = GpsInfoRecord.createRecord(source);
            System.out.println(record);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }
}