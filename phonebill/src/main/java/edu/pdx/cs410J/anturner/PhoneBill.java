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

    public PhoneBill() {}

    public PhoneBill(String name, PhoneCall passedCall) {
        this.customerName = name;
        this.calls = new ArrayList<PhoneCall>();
        this.calls.add(passedCall);

    }

    public void setCustomerName(String passName) {
        customerName = passName;
    }

    @Override
    public String getCustomer() {
        return customerName;
    }

    @Override
    public void addPhoneCall(AbstractPhoneCall abstractPhoneCall) {
        this.calls.add((PhoneCall) abstractPhoneCall);
    }

    @Override
    public Collection getPhoneCalls() {
        return this.calls;
    }

    public void print() {
        System.out.println(this.calls.toString());
    }

}
