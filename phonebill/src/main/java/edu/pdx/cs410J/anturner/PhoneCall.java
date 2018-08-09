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
  private String endTime;

  public PhoneCall(){
      callerNumber = null;
      calleeNumber = null;
      startTime = null;
      endTime = null;
  }

  public PhoneCall(String callerPassNumber, String calleePassNumber, String passStartTime, String passEndTime) {

      try{
          validatePhoneNumber(callerPassNumber);
          callerNumber = callerPassNumber;
      }catch (IllegalArgumentException e){
          callerNumber = "Phone number must be 10 digits.";
      }

      try{
          validatePhoneNumber(calleePassNumber);
          calleeNumber = callerPassNumber;
      }catch (IllegalArgumentException e){
          calleeNumber = "Phone number must be 10 digits.";
      }

      try{
          startTime = validateTime(passStartTime);
      } catch (IllegalArgumentException e){
          startTime = "Start time is invalid";
      }

      try{
          endTime = validateTime(passEndTime);
      } catch (IllegalArgumentException e){
          endTime = "End time is invalid";
      }


  }

  public String validateTime(String passTime){

      if (passTime == "" || passTime == null)
          throw new IllegalArgumentException("Invalid time.");
      else if (!passTime.contains(":"))
          throw new IllegalArgumentException("Invalid time.");
      else if (passTime.contains(" ") == false)
          throw new IllegalArgumentException("Invalid time.");
      else {

          //  Split the start time String
          String[] parts = passTime.split(" ");
          String[] date = parts[0].split("/");
          String[] time = parts[1].split(":");

          //  Initialize time variables hours minutes.
          int hours = Integer.parseInt(time[0]);
          int minutes = Integer.parseInt(time[1]);

          int month = Integer.parseInt(date[0]);
          int day = Integer.parseInt(date[1]);
          int year = Integer.parseInt(date[2]);

          //  Check if time format is valid
          if(month <= 0 || month > 12 || date[0].length() < 1 || date[0].length() > 2  )
              throw new IllegalArgumentException("Invalid Month.");
          if(day <= 0 || day > 31 || date[1].length() < 2 || date[1].length() > 2  )
              throw new IllegalArgumentException("Invalid Date.");
          if(year <= 2016 || date[2].length() < 4 || date[2].length() > 4  )
              throw new IllegalArgumentException("Invalid Year.");
          if (hours > 24 || hours < 0)
              throw new IllegalArgumentException("Invalid hours.");
          if (minutes > 59 || minutes < 0)
              throw new IllegalArgumentException("Invalid minutes.");
          else
              return passTime;
      }

  }

    /**
     * The Start time
     */
    @Override
    public String getStartTimeString() {

        return validateTime(this.startTime);
    }

    @Override
    public String getEndTimeString() {

        return validateTime(this.endTime);
    }


  public void validatePhoneNumber(String number){

      if(number.length() < 10 || (number.length() > 10  && number.length() > 12) ) {
          throw new IllegalArgumentException("Phone number must be 10 digits.");
      }
      if(number.length() == 12){
          if(number.charAt(3) != '-' && number.charAt(7) != '-'){
              throw new IllegalArgumentException("Phone number must be 10 digits.");
          }
          else {
              if(number.substring(0,2).matches("[0-9]+")){
                  if(number.substring(8,12).matches("[0-9]+")){

                  }
                  else {
                      throw new IllegalArgumentException("Phone number invalid format.");
                  }
              }
              else{
                  throw new IllegalArgumentException("Phone number invalid format.");
              }
          }
      }
      if(number.length() == 10) {
          if (number.matches("[0-9]+")) {

          }
          else {
              throw new IllegalArgumentException("Caller number must be 10 digits.");
          }
      }
  }

  @Override
  public String getCaller() {
      if(callerNumber != null)
          return callerNumber;
      else {
          return "Caller number not given";
      }
  }

  private void setCallerNumber(String number) {
      try{
          validatePhoneNumber(number);
      }catch (IllegalArgumentException e){
          callerNumber = "Phone number must be 10 digits.";
      }
  }

  @Override
  public String getCallee() {
      if(calleeNumber != null)
          return calleeNumber;
      else {
          return "Callee number not given";
      }
  }

  public String printString(){
        return toString();
  }

  public void printCall(){
      System.out.print(getCaller());
  }

}
