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
     * Tests that invoking the main method with happy path arguments
     */
    @Test
    public void testHappyPathWithPrint() {

        String arg0 = "Another Name";
        String arg1 = "000-000-0000";
        String arg2 = "111-111-1111";
        String arg3 = "1/15/2018 19:40";
        String arg4 = "1/15/2018 19:40";
        String arg5 = "-print";
        //String readme = "-readme";

        //MainMethodResult result = invokeMain(arg0, arg1, arg2, arg3, arg4, arg5);

        //MainMethodResult result = invokeMain("another name", "000-000-0000","111-111-1111", "1/15/2018 19:40");
        //System.out.println(result.getTextWrittenToStandardOut());

       // assertThat(result.getTextWrittenToStandardOut(), containsString("Another"));
    }

    @Test
    public void testHappyPathWithReadMeAsFith() {

        String arg0 = "Another Name";
        String arg1 = "000-000-0000";
        String arg2 = "111-111-1111";
        String arg3 = "1/15/2018 19:40";
        String arg4 = "1/15/2018 19:40";
        String arg5 = "-readme";
        String arg6 = "-p";

        MainMethodResult result = invokeMain(arg0, arg1, arg2, arg3, arg4, arg5, arg6); // , arg3, arg4);

        System.out.println(result.getTextWrittenToStandardOut());
        assertThat(result.getTextWrittenToStandardOut(), containsString("This"));
    }


}