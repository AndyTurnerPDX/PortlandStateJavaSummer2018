package edu.pdx.cs410J.anturner;

import org.junit.Test;

import java.lang.instrument.IllegalClassFormatException;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link PhoneCall} class.
 */
public class PhoneCallTest {

  @Test(expected = UnsupportedOperationException.class)
  public void setCallerNameNeedsToBeImplemented() {
    PhoneCall call = new PhoneCall();
    assertThat(call.getCaller(), containsString("not implemented"));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void getStartTimeStringNeedsToBeImplemented() {
    PhoneCall call = new PhoneCall();
    call.getStartTimeString();
  }

  @Test (expected = UnsupportedOperationException.class)
  public void initiallyAllPhoneCallsHaveTheSameCallee() {
    PhoneCall call = new PhoneCall();
    assertThat(call.getCallee(), containsString("not implemented"));
  }

  @Test
  public void forProject1ItIsOkayIfGetStartTimeReturnsNull() {
    PhoneCall call = new PhoneCall();
    assertThat(call.getStartTime(), is(nullValue()));
  }

  @Test
  public void invalidCallerPhoneNumber() {
      String callerPhoneNumberShort = "123456789";    // Given

      try{
          createCallerWithNumber(callerPhoneNumberShort); // When
          fail();
      } catch (IllegalArgumentException ex) {
          // Then except this exception to occur
      }

      String callerPhoneNumberLong = "12345678901234";

      try{
          createCallerWithNumber(callerPhoneNumberLong);
          fail();
      } catch (IllegalArgumentException ex) {
          // Then except this exception
      }

      String callerPhoneNumberBad = "1-23-4567890";

      try{
          createCallerWithNumber(callerPhoneNumberBad);
          fail();
      } catch (IllegalArgumentException ex) {
          // Then except this exception
      }

      String callerPhoneNumberContainsLetter = "A23-456-7890";

      try{
          createCallerWithNumber(callerPhoneNumberContainsLetter);
          fail();
      } catch (IllegalArgumentException ex) {
          // Then except this exception
      }

  }

  @Test
  public void happyPathPhoneNumber() {
      String callerPhoneNumber = "123-456-7890";    // Given

      try{
          createCallerWithNumber(callerPhoneNumber); // When
          fail();
      } catch (IllegalArgumentException ex) {
          // Then except this exception to occur
      }
  }



    private void createCallerWithNumber(String callerPhoneNumber) {
      new PhoneCall(callerPhoneNumber, "0", "1", "2");
    }

}
