package edu.pdx.cs410J.anturner;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link PhoneBill} class.
 */

public class PhoneBillTest {

    @Test
    public void customerNameIsPat() {
        String passName = "Pat";
        var pat = new PhoneBill(passName, new ArrayList<>());
        assertThat(pat.getCustomer(), equalTo(passName));
    }

}
