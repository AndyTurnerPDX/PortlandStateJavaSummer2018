package edu.pdx.cs410J.anturner;

/**
 * Phone call is initiated by a person with a given phone number at a given time,
 * is received by a person with a given phone number, and terminates at a given time.
 *
 * All data should be modeled with strings.
 *
 *
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

    /**
     * @param callerPassNumber  passed in Callers number
     * @param calleePassNumber  passed in Callees number
     * @param passStartTime     passed in Start Time
     * @param passEndTime       passed in End Time
     */
  public PhoneCall(String callerPassNumber, String calleePassNumber, String passStartTime, String passEndTime) {

      try{
          validatePhoneNumber(callerPassNumber);
          callerNumber = callerPassNumber;
      }catch (IllegalArgumentException e){
          throw new IllegalArgumentException(e.getMessage());
      }

      try{
          validatePhoneNumber(calleePassNumber);
          calleeNumber = callerPassNumber;
      }catch (IllegalArgumentException e){
          throw new IllegalArgumentException(e.getMessage());
      }

      try{
          startTime = validateTime(passStartTime);
      } catch (IllegalArgumentException e){
          throw new IllegalArgumentException(e.getMessage());
      }

      try{
          endTime = validateTime(passEndTime);
      } catch (IllegalArgumentException e){
          throw new IllegalArgumentException(e.getMessage());
      }


  }

    /**
     *
     * @param passTime
     * @return passTime if it is valid
     * @throws IllegalArgumentException if time is invalid
     */
  public String validateTime(String passTime){

      if (passTime == "" || passTime == null)
          throw new IllegalArgumentException("Invalid time.");
      else if (!passTime.contains(":"))
          throw new IllegalArgumentException("Time is missing.");
      else {

          int hours = 0;
          int minutes = 0;
          int month = 0;
          int day = 0;
          int year = 0;

          //  Split the start time String
          String[] parts = passTime.split(" ");
          String[] date = parts[0].split("/");
          String[] time = parts[1].split(":");

          //  Initialize time variables hours minutes.
          if(time[0].matches("[0-9]+"))
              hours = Integer.parseInt(time[0]);
          else
              throw new IllegalArgumentException("Hours must contain letters.");

          if(time[1].matches("[0-9]+"))
              minutes = Integer.parseInt(time[1]);
          else
              throw new IllegalArgumentException("Minutes cannot contain letters.");

          if(date[0].matches("[0-9]+"))
              month = Integer.parseInt(date[0]);
          else
              throw new IllegalArgumentException("Month cannot contain letters");

          if(date[1].matches("[0-9]+"))
              day = Integer.parseInt(date[1]);
          else
              throw new IllegalArgumentException("Day cannot contain letters.");

          if(date[2].matches("[0-9]+"))
              year = Integer.parseInt(date[2]);
          else
              throw new IllegalArgumentException("Year cannot contain letters.");

          if((month == 0) || (day == 0 ) || (year == 0))
              throw new IllegalArgumentException("Date is missing.");

          //  Check if time format is valid
          if(month <= 0 )
              throw new IllegalArgumentException("Month must be greater than 0.");
          if(month > 12)
              throw new IllegalArgumentException("Month must be less than or equal to 12.");
          if(date[0].length() < 1 || date[0].length() > 2)
              throw new IllegalArgumentException("Moth must be in format M or MM.");
          if(day <= 0 )
              throw new IllegalArgumentException("Day must be at least 1.");
          if(day > 31)
              throw new IllegalArgumentException("Day cannot be greater than 31.");
          if(date[1].length() < 2 || date[1].length() > 2)
              throw new IllegalArgumentException("Day must be in format D or DD.");
          if(date[2].length() < 4 || date[2].length() > 4  )
              throw new IllegalArgumentException("Year must be in format YYYY");
          if (hours > 24 || hours < 0)
              throw new IllegalArgumentException("Hours must be between 0-24.");
          if (minutes > 59 || minutes < 0)
              throw new IllegalArgumentException("Minutes must be between 0-59.");
          else
              return passTime;
      }

  }

    /**
     * @return is this time is start time is valid
     */
    @Override
    public String getStartTimeString() {

        return validateTime(this.startTime);
    }

    /**
     *
     * @return endTime if endtime is valid
     */
    @Override
    public String getEndTimeString() {

        return validateTime(this.endTime);
    }

    /**
     *
     * @param number passed in phone number to see if it valid
     * @throws IllegalArgumentException if phone number isn't valid
     *
     */
    public void validatePhoneNumber(String number){

      if(number.length() < 10 )
          throw new IllegalArgumentException("Phone number must be at least 10 digits.");
      if(number.length() > 12)
          throw new IllegalArgumentException("Too many digits in the phone number");
      if(number.length() == 12){
          if(number.charAt(3) != '-' && number.charAt(7) != '-'){
              throw new IllegalArgumentException("Phone number is in an invalid format.");
          }
          else {
              if(number.substring(0,2).matches("[0-9]+")){
                  if(number.substring(8,12).matches("[0-9]+")){

                  }
                  else {
                      throw new IllegalArgumentException("Phone number cannot contain letters.");
                  }
              }
              else{
                  throw new IllegalArgumentException("Phone number cannot contain letters.");
              }
          }
      }
      if(number.length() == 10) {
          if (number.matches("[0-9]+")) {

          }
          else {
              throw new IllegalArgumentException("Phone number cannot contain letters.");
          }
      }

    }

    /**
     *
     * @return valid caller number
     */
    @Override
    public String getCaller() {
        if(callerNumber != null)
          return callerNumber;
        else {
            return "Caller number not given";
        }
    }

    /**
     *
     * @param number
     */
    private void setCallerNumber(String number) {
        try{
            validatePhoneNumber(number);
        }catch (IllegalArgumentException e){
            callerNumber = "Phone number must be 10 digits.";
        }
    }

    /**
     *
     * @return calleeNumber
     */
    @Override
    public String getCallee() {
        if(calleeNumber != null)
            return calleeNumber;
        else {
            return "Callee number not given";
        }
    }

    /**
     *
     * @return print using to AbstractPhoneCall toString() method
     */
    public String printString() {
        return toString();
    }

    /**
     * outputs get caller
     */
    public void printCall(){
        System.out.print(getCaller());
    }

}
