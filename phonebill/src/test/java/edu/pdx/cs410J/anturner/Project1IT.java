package edu.pdx.cs410J.anturner;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.*;
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

    @Test
    public void anotherMultiWordedName(){
        String arg = "-print";
        String arg0 = "Test 6";
        String arg1 = "123-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018 12:00";
        String arg4 = "04/04/2018 9:00";

        MainMethodResult result = invokeMain(arg, arg0, arg1, arg2, arg3, arg4);

        System.out.println(result.getTextWrittenToStandardOut());

    }


    @Test
    public void anotherPrintTest(){
        String arg = "-print";
        String arg0 = "Test6";
        String arg1 = "123-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018 12:00";
        String arg4 = "04/04/2018 9:00";

        MainMethodResult result = invokeMain(arg, arg0, arg1, arg2, arg3, arg4);

        System.out.println(result.getTextWrittenToStandardOut());

    }

    @Test
    public void readMeOnly(){
        String arg = "-readme";

        MainMethodResult result = invokeMain(arg);

        System.out.println(result.getTextWrittenToStandardOut());
        assertThat(result.getTextWrittenToStandardError(), containsString(""));

    }

    @Test
    public void test10MissingEndTime(){
        String arg0 = "Test6";
        String arg1 = "123-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018 12:00";
        String arg4 = "04/04/2018";

        MainMethodResult result = invokeMain(arg0, arg1, arg2, arg3, arg4);

        System.out.println(result.getTextWrittenToStandardOut());
        //System.out.println(result.getTextWrittenToStandardError());
        assertThat(result.getTextWrittenToStandardOut(), containsString("missing"));
    }

    @Test
    public void test7UknownCommandLineArgument(){
        String arg = "fred";
        String arg0 = "Test6";
        String arg1 = "123-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018 12:00";
        String arg4 = "04/04/2018 19:40";

        MainMethodResult result = invokeMain(arg0, arg1, arg2, arg3, arg4, arg);

        System.out.println(result.getTextWrittenToStandardError());
        assertThat(result.getTextWrittenToStandardError(), containsString("Invalid"));
    }

    @Test
    public void test6UnknownCommandLineOption(){
        String arg = "-fred";
        String arg0 = "Test6";
        String arg1 = "123-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018 12:00";
        String arg4 = "04/04/2018 19:40";

        MainMethodResult result = invokeMain(arg, arg0, arg1, arg2, arg3, arg4);

        System.out.println(result.getTextWrittenToStandardOut());
        //assertThat(result.getTextWrittenToStandardOut(), not(containsString("Invalid Command Line Argument")));
    }

    @Test
    public void test5EndTimeMalformatted(){
        String arg0 = "Test5";
        String arg1 = "123-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018 12:00";
        String arg4 = "01/04/20/1 19:40";

        MainMethodResult result = invokeMain(arg0, arg1, arg2, arg3, arg4);

        //System.out.println(result.getTextWrittenToStandardOut());
        assertThat(result.getTextWrittenToStandardOut(), not(containsString("invalid year")));

    }
    @Test
    public void test4IllegalStartTime(){
        String arg0 = "Another Name";
        String arg1 = "123-132-0000";
        String arg2 = "111-111-1111";
        String arg3 = "1/15/2018 19:XX";
        String arg4 = "1/15/2018 19:40";

        MainMethodResult result = invokeMain(arg0, arg1, arg2, arg3, arg4);

        //System.out.println(result.getTextWrittenToStandardOut());
        assertThat(result.getTextWrittenToStandardOut(), not(containsString("invalid minutes")));

    }

    @Test
    public void removeIllegalArgumentException(){
            String arg0 = "Another Name";
            String arg1 = "ABC-ABC-0000";
            String arg2 = "111-111-1111";
            String arg3 = "1/15/2018 19:40";
            String arg4 = "1/15/2018 19:40";

            MainMethodResult result = invokeMain(arg0, arg1, arg2, arg3, arg4);

        System.out.println(result.getTextWrittenToStandardOut());
        assertThat(result.getTextWrittenToStandardOut(), not(containsString("java.lang.IllegalArgumentException")));

    }

    @Test //(expected = IllegalArgumentException.class)
    public void testBadTest() {
        String arg0 = "Another Name";
        String arg1 = "ABC-000-0000";
        String arg2 = "111-111-1111";
        String arg3 = "1/15/2018 19:40";
        String arg4 = "1/15/2018 19:40";

        MainMethodResult result = invokeMain(arg0, arg1, arg2, arg3, arg4);

        System.out.println(result.getTextWrittenToStandardOut());
    }


  /**
   * Tests that invoking the main method with no arguments issues an error
   */
  @Test
  public void testNoCommandLineArguments() {
      MainMethodResult result = invokeMain();

      System.out.println(result.getTextWrittenToStandardOut());
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

        MainMethodResult result = invokeMain(arg0, arg1, arg2, arg3, arg4, arg5);

        //MainMethodResult result = invokeMain("another name", "000-000-0000","111-111-1111", "1/15/2018 19:40");
        System.out.println(result.getTextWrittenToStandardOut());

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
        //assertThat(result.getTextWrittenToStandardOut(), containsString("This"));
    }


}