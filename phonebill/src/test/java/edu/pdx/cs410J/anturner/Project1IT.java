package edu.pdx.cs410J.anturner;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests the functionality in the {@link Project1} main class.
 */
public class Project1IT extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link Project1} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain( Project1.class, args );
    }

  /**
   * Tests that invoking the main method with no arguments issues an error
   */
  @Test
  public void testNoCommandLineArguments() {
    MainMethodResult result = invokeMain();
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
  }

    /**
     * Tests that invoking the main method with no arguments issues an error
     */
    @Test
    public void testNoQuoteWithNameCommandLineArguments() {

        String noQuoteAroundName = "Andy";
        String anotherArgument = "Turner";
        MainMethodResult result = invokeMain(noQuoteAroundName,anotherArgument);
        System.out.println(result.getTextWrittenToStandardOut());
        assertThat(result.getExitCode(), equalTo(1));
        //assertThat(result.getTextWrittenToStandardError(), containsString("Invalid command line arguments"));
    }

    /**
     * Tests that invoking the main method with no arguments issues an error
     */
    @Test
    public void testWithQuoteWithOneNameCommandLineArguments() {

        String noQuoteAroundName = "Andy Turner";
        MainMethodResult result = invokeMain(noQuoteAroundName);
        assertThat(result.getExitCode(), equalTo(1));
        //assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
        System.out.println(result.getTextWrittenToStandardOut());
    }

    /**
     * Tests that invoking the main method with no arguments issues an error
     */
    @Test
    public void testWithQuoteWithTwoNameCommandLineArguments() {

        String withQuoteAroundName = "\"Andy Turner\"";
        MainMethodResult result = invokeMain(withQuoteAroundName);
        assertThat(result.getExitCode(), equalTo(1));
       // assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
    }

    /**
     * Tests that invoking the main method with happy path arguments
     */
    @Test
    public void testHappyPathWithPrint() {

        String argCustomerName = "Another Name";
        String callerNumber = "000-000-0000";
        String calleeNumber = "111=111=1111";
        String startTime = "1/15/2018 19:40";
        String endTime = "1/15/2018 19:40";
        String print = "-print";

        MainMethodResult result = invokeMain(argCustomerName, calleeNumber,calleeNumber, startTime, endTime, print);
        assertThat(result.getTextWrittenToStandardOut(), containsString("print"));
    }
}