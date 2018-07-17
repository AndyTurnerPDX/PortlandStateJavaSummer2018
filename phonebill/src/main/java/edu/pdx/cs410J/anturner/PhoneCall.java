package edu.pdx.cs410J.anturner;

/**
 * Phone call is initiated by a person with a given phone number at a given time,
 * is received by a person with a given phone number, and terminates at a given time.
 *
 * All data should be modeled with strings.
 */

import edu.pdx.cs410J.AbstractPhoneCall;

public class PhoneCall extends AbstractPhoneCall {

  private String callerNumber;
  private String calleeNumber;
  private String startTime;
  private String endTIme;

  public PhoneCall(){}

  public PhoneCall(String callerPassNumber, String calleePassNumber, String passStartTime, String passEndTime) {

      setCallerNumber(calleePassNumber);

  }

  @Override
  public String getCaller() { throw new UnsupportedOperationException("This method is not implemented yet"); }

  public void setCallerNumber(String number) {

      if(number.length() < 10 || number.length() > 10  ) {
          throw new IllegalArgumentException("Caller number must be 10 digits.");
      }
      if(number.length() == 13){
          // 012-456-8901
          if(number.charAt(3) == '-' && number.charAt(7) == '-'){
              throw new IllegalArgumentException("Caller number must be 10 digits.");
          }
          else {
              callerNumber = number;
          }
      }
      if(number.length() == 10)
          if(number.matches("[0-9]+"))
              callerNumber = number;
      else
          throw new IllegalArgumentException("Caller number must be 10 digits.");
  }

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
