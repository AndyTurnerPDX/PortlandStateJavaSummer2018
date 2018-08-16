package edu.pdx.cs410J.anturner;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by an_d on 7/19/17.
 */
public class TextDumperTest {

    TextDumper textDump = new TextDumper();
    Airline a = new Airline();

    Flight fValid = new Flight();
    Flight fValid2 = new Flight();


    /**
     * Set up the class
     */
    @Before
    public void setUP() {
        a.setName("AndyAir");
        fValid.setFlightNumber(1234);
        fValid.setSource("DUM");
        fValid.setDepartTime("05/01/2018 10:45");
        fValid.setDestination("PER");
        fValid.setArrivalTime("05/01/2018 10:49");

        a.addFlight(fValid);

        fValid2.setFlightNumber(35);
        fValid2.setSource("tst");
        fValid2.setDepartTime("05/04/2018 10:45");
        fValid2.setDestination("ert");
        fValid2.setArrivalTime("05/04/2018 10:49");

        a.addFlight(fValid2);

    }

    /**
     *
     * Test Dumping one airline
     */
    @Test
    public void testDumpOneAirline() throws IOException {
        a.addFlight(fValid);

    }

    @Test
    public void testAssertThat() {
        String name = "";
        a.setName(name);
        assertThat(a.getName(), equalTo("Flight name is invalid"));
    }

    @Test
    public void testMultipleFlights() throws IOException{
        a.addFlight(fValid);
        a.addFlight(fValid2);

        String s = "success";
        try{
            textDump.dump(a);
        } catch (Exception e) {
            s = "fail";
        }

        assertThat(s, equalTo("success"));
    }


}
