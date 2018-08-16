package edu.pdx.cs410J.anturner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by an_d on 7/19/17.
 */
public class TextParserTest {

    TextParser textParser;
    Airline airline;

    /**
     * Before the rest of class is invoked
     *
     */
    @Before
    public void setUP() {
        textParser = new TextParser();
        airline = new Airline();
    }

    /**
     * Test File does exist
     */
    @Test
    public void testToSeeThatFileDoesExists() {
        boolean work = false;

        try {
            if(textParser.checkFile("input.txt", airline))
                work = true;
            else
                work = false;
        } catch (IOException e) {
            //e.printStackTrace();
        }
        assertThat(work, equalTo(true));

    }

    /**
     * Test File does not exist
     */
    @Test
    public void testToSeeThatFileDoesNotExists() {
        boolean work = true;

        try {
            if(textParser.checkFile("fileNotFound.txt", airline))
                work = true;
            else
                work = false;
        } catch (IOException e) {
            //e.printStackTrace();
        }
        assertThat(work, equalTo(false));

    }

    /**
     * Test Airplane passed in
     */
    @Test
    public void testToSeeThatAirlineIsUsed() {
        boolean work = true;

        try {
            if(textParser.checkFile("input.txt", this.airline))
                work = true;
            else
                work = false;
        } catch (IOException e) {
            //e.printStackTrace();
        }
        assertThat(this.airline.getName(), containsString("Air"));

    }

}
