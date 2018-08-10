package edu.pdx.cs410J.anturner;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.fail;

/**
 * Unit tests for the {@link PhoneCall} class.
 */
public class PhoneCallTest {

    @Test
    public void testTimeNotValid(){
        // Given
        String passCaller = "ABC-111-1111";
        String passCallee = "222-222-2222";
        String passStart = "1/15/2018 19:XX";
        String passEnd = "2/15/2018 19:39";

        try{
            new PhoneCall(passCaller, passCallee, passStart, passEnd);
            fail();

        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

  @Test
  public void testCallNumberContNonInt(){
      // Given
      String passCaller = "ABC-111-1111";
      String passCallee = "222-222-2222";
      String passStart = "1/15/2018 19:39";
      String passEnd = "2/15/2018 19:39";

      try{
          new PhoneCall(passCaller, passCallee, passStart, passEnd);
          fail();

      }catch (IllegalArgumentException ex){

      }

  }

  @Test
  public void setCallerNameNeedsToBeImplemented() {
    PhoneCall call = new PhoneCall();
    // System.out.println(call.getCaller());
    assertThat(call.getCaller(), containsString("not"));
  }

  @Test
  public void initiallyAllPhoneCallsHaveTheSameCallee() {
    PhoneCall call = new PhoneCall();
    assertThat(call.getCallee(), containsString("not"));
  }


//  @Test
//  public void invalidCallerPhoneNumberTooShort() {
//      String callerPhoneNumberShort = "123456789";    // Given
//      PhoneCall call = new PhoneCall(callerPhoneNumberShort, callerPhoneNumberShort, "1", "2");
//
//      assertThat(call.getCaller(), containsString("must be"));
//
//  }
//
//  @Test
//  public void invalidPhoneNumberTooLong(){
//      String callerPhoneNumberLong = "12345678901234";
//      PhoneCall call = new PhoneCall(callerPhoneNumberLong, callerPhoneNumberLong, "1", "2");
//
//      assertThat(call.getCaller(), containsString("must be"));
//  }
//
//  @Test
//  public void invalidPhoneNumberBadChars(){
//      String callerPhoneNumberBad = "1-23-4567890";
//      PhoneCall call = new PhoneCall(callerPhoneNumberBad, callerPhoneNumberBad, "1", "2");
//
//      assertThat(call.getCallee(), containsString("must be"));
//  }
//
//  @Test
//  public void invalidPhoneNumberContLettr(){
//      String callerPhoneNumberContainsLetter = "A23-456-7890";
//      PhoneCall call = new PhoneCall(callerPhoneNumberContainsLetter, callerPhoneNumberContainsLetter, "1", "2");
//
//      assertThat(call.getCaller(), containsString("must be"));
//  }
//
//  @Test
//  public void happyPathPhoneNumber() {
//      String callerPhoneNumber = "123-456-7890";    // Given
//      PhoneCall call = new PhoneCall(callerPhoneNumber, callerPhoneNumber, "1", "2");
//
//      assertThat(call.getCaller(), containsString("123"));
//  }
//
//  @Test
//  public void happyPathPhoneNumber10Dig() {
//      String callerPhoneNumber = "0123456789";    // Given
//      PhoneCall call = new PhoneCall(callerPhoneNumber, callerPhoneNumber, "1", "2");
//
//      assertThat(call.getCaller(), containsString("123"));
//  }

  private void createCallerWithNumber(String callerPhoneNumber) {
      new PhoneCall(callerPhoneNumber, "0", "1", "2");
  }

}
