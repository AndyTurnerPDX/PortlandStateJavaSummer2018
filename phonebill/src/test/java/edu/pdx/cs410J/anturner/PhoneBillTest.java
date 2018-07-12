package edu.pdx.cs410J.anturner;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link PhoneBill} class.
 */

public class PhoneBillTest {

    @Test
    public void customerNameIsPat() {
        String passName = "Pat";
        var pat = new PhoneBill(passName);
        assertThat(pat.getCustomer(), equalTo(passName));
    }

}
