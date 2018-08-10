package edu.pdx.cs410J.anturner;
import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.AbstractPhoneCall;

import java.util.ArrayList;
import java.util.Collection;

/**
 * PhoneBill has a customer name and consists of multiple PhoneCalls.
 *
 */


public class PhoneBill extends AbstractPhoneBill {

    private String customerName;
    ArrayList<PhoneCall> calls;

    public PhoneBill() {}

    /**
     *
     * @param name passed in customer name
     * @param passedCall passed in phone call
     */
    public PhoneBill(String name, PhoneCall passedCall) {
        this.customerName = name;
        this.calls = new ArrayList<PhoneCall>();
        this.calls.add(passedCall);

    }

    /**
     * @param passName sets customerName to the passed in Name
     */
    public void setCustomerName(String passName) {
        customerName = passName;
    }

    /**
     *
     * @return returns customerName
     */
    @Override
    public String getCustomer() {
        return customerName;
    }

    /**
     *
     * @param abstractPhoneCall adds a phonecall
     */
    @Override
    public void addPhoneCall(AbstractPhoneCall abstractPhoneCall) {
        this.calls.add((PhoneCall) abstractPhoneCall);
    }

    /**
     *
     * @return returns calls in the list
     */
    @Override
    public Collection getPhoneCalls() {
        return this.calls;
    }

    /**
     * prints the customer name and the calls using to string
     */
    public void print() {
        System.out.println(this.customerName + " " + this.calls.toString());
    }

}
