package edu.pdx.cs410J.anturner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by an_d on 7/18/17.
 *
 * Class TextParser reads the contents of a text file and from it
 * creates an PhoneBill with its associated flights.
 */
public class TextParser {

    /**
     * checkFile checks to see if the passed in file is valid
     *
     */
    public boolean checkFile(String passedInFile, PhoneBill a) throws IOException {

        InputStream is = null;

        String filePath = "/Users/an_d/Documents/school/2017 Summer/CS 410 - Java/git/PortlandStateJavaSummer2017/PhoneBill/src/main/java/edu/pdx/cs410J/";

        int i;
        char c;

        String tempInput = new String();

        String tempName = "";
        String tempCaller = "";
        String tempCallee = "";
        String tempStartDate = "";
        String tempStartTime = "";
        String tempEndDate = "";
        String tempEndTime = "";

        PhoneBill bill;
        PhoneCall call;

        try {

            passedInFile = filePath + passedInFile;

            is = new FileInputStream(passedInFile);

            while((i = is.read()) !=-1) {

                //  converts integer to character
                c = (char)i;

                if(c != '\n')
                    tempInput+=c;
                else {

                    if(tempName == "")
                        tempName = tempInput;
                    else if(tempCaller == "")
                        tempCaller = tempInput;
                    else if(tempCallee == "")
                        tempCallee = tempInput;
                    else if(tempStartDate == "")
                        tempStartDate = tempInput;
                    else if(tempStartTime == "")
                        tempStartTime = tempInput;
                    else if(tempEndDate == "")
                        tempEndDate = tempInput;
                    else if(tempEndTime == "")
                        tempEndTime = tempInput;

                    try {
                        tempStartDate = tempStartDate + " " + tempStartTime;
                        tempEndDate = tempEndDate + " " + tempEndTime;
                        call = new PhoneCall(tempCaller, tempCallee, tempStartDate, tempEndDate);  // Refer to one of Dave's classes so that we can be sure it is on the classpath
                        bill = new PhoneBill(tempName, call);

                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                    tempInput = new String();
                    tempName = "";
                    tempCaller = "";
                    tempCallee = "";
                    tempStartDate = "";
                    tempStartTime = "";
                    tempEndDate = "";
                    tempEndTime = "";
                }
                //  prints character
                System.out.print(c);
            }

        } catch (Exception e) {
            System.err.println("Unable to read File.");
            return false;

        } finally {
            //  release system resources
            if(is!=null)
                is.close();
        }
        return true;
    }

}
