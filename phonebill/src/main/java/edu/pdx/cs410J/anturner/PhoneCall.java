package edu.pdx.cs410J.anturner;

/**
 * Phone call is initiated by a person with a given phone number at a given time,
 * is received by a person with a given phone number, and terminates at a given time.
 *
 * All data should be modeled with strings.
 */

import edu.pdx.cs410J.AbstractPhoneCall;

public class PhoneCall extends AbstractPhoneCall {

  private String caller;
  private String callee;

  @Override
  public String getCaller() { throw new UnsupportedOperationException("This method is not implemented yet"); }

  @Override
  public String getCallee() { throw new UnsupportedOperationException("This method is not implemented yet"); }

  @Override
  public String getStartTimeString() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }

  @Override
  public String getEndTimeString() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }

}
