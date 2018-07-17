package edu.pdx.cs410J.anturner;
import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.AbstractPhoneCall;

import java.util.ArrayList;
import java.util.Collection;

/**
 * PhoneBill has a customer name and consists of multiple PhoneCalls.
 */


public class PhoneBill extends AbstractPhoneBill {

    private String customerName;
    ArrayList<PhoneCall> calls;


    public PhoneBill(String name, ArrayList<String> calls) {
        customerName = name;

    }

    private void setCustomerName(String passName) {
        customerName = passName;
    }

    @Override
    public String getCustomer() {
        return customerName;
    }

    @Override
    public void addPhoneCall(AbstractPhoneCall abstractPhoneCall) {

    }

    @Override
    public Collection getPhoneCalls() {
        return null;
    }


}
