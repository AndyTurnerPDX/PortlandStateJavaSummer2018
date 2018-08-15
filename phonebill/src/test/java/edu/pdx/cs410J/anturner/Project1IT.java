package edu.pdx.cs410J.anturner;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
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

    @Test
    public void anotherMultiWordedName(){
        String arg = "-print";
        String arg0 = "Test 6";
        String arg1 = "123-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018";
        String arg4 = "12:00";
        String arg5 = "04/04/2018";
        String arg6 = "9:00";

        MainMethodResult result = invokeMain(arg, arg0, arg1, arg2, arg3, arg4, arg5, arg6);

        System.out.println(result.getTextWrittenToStandardOut());

    }

    @Test
    public void anotherPrintTest(){
        String arg0 = "Test6";
        String arg1 = "ABC-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018";
        String arg4 = "12:00";
        String arg5 = "04/04/2018";
        String arg6 = "9:00";

        MainMethodResult result = invokeMain(arg0, arg1, arg2, arg3, arg4, arg5, arg6);

        //System.out.println(result.getTextWrittenToStandardOut());
        assertThat(result.getTextWrittenToStandardOut(), containsString("letters"));
    }

    @Test
    public void timeMalformated(){
        String arg0 = "Test6";
        String arg1 = "809-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018";
        String arg4 = "12:00";
        String arg5 = "04/04/2018";
        String arg6 = "9:XX";

        MainMethodResult result = invokeMain(arg0, arg1, arg2, arg3, arg4, arg5, arg6);

        //System.out.println(result.getTextWrittenToStandardOut());
        assertThat(result.getTextWrittenToStandardOut(), containsString("letters"));
    }

    @Test
    public void badArg1(){
        String arg0 = "Test6";
        String arg1 = "000-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018";
        String arg4 = "12:00";
        String arg5 = "04/04/2018";
        String arg6 = "9:00";
        String arg7 = "fred";

        MainMethodResult result = invokeMain(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);

        //System.out.println(result.getTextWrittenToStandardError());
        assertThat(result.getTextWrittenToStandardError(), containsString("Invalid"));
    }

    @Test
    public void badCommandLineOption(){
        String arg = "-fred";
        String arg0 = "Test6";
        String arg1 = "000-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018";
        String arg4 = "12:00";
        String arg5 = "04/04/2018";
        String arg6 = "9:00";

        MainMethodResult result = invokeMain(arg, arg0, arg1, arg2, arg3, arg4, arg5, arg6);

        // System.out.println(result.getTextWrittenToStandardError());
        assertThat(result.getTextWrittenToStandardError(), containsString("Invalid"));
    }

    @Test
    public void print(){
        String arg = "-print";
        String arg0 = "Test6";
        String arg1 = "000-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018";
        String arg4 = "12:00";
        String arg5 = "04/04/2018";
        String arg6 = "9:00";

        MainMethodResult result = invokeMain(arg, arg0, arg1, arg2, arg3, arg4, arg5, arg6);

        assertThat(result.getTextWrittenToStandardOut(), containsString("Test6"));
    }

    @Test
    public void missingEndTIme(){
        String arg = "-print";
        String arg0 = "Test6";
        String arg1 = "000-456-7890";
        String arg2 = "234-567-8901";
        String arg3 = "03/03/2018";
        String arg4 = "12:00";

        MainMethodResult result = invokeMain(arg, arg0, arg1, arg2, arg3, arg4);

        System.out.println(result.getTextWrittenToStandardOut());
        assertThat(result.getTextWrittenToStandardOut(), containsString("missing"));
    }



}