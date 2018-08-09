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

        String passCaller = "111-222-3333";
        String passCallee = "444-555-6666";
        String passStart = "1/15/2018 19:39";
        String passEnd = "2/15/2018 19:39";
        PhoneCall call = new PhoneCall(passCaller, passCallee, passStart, passEnd);

        PhoneBill bill = new PhoneBill(passName, call);

        System.out.println(bill.getPhoneCalls());

        // var pat = new PhoneBill(passName);
        //assertThat(pat.getCustomer(), equalTo(passName));
    }



}
