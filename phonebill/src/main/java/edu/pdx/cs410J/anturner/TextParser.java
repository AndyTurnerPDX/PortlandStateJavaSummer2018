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

        String filePath = "/Users/an_d/Documents/school/2017 Summer/CS 410 - Java/git/PortlandStateJavaSummer2017/PhoneBill/src/main/java/edu/pdx/cs410J/anturner/";

        int i;
        char c;

        String tempInput = new String();

        String tempName = null;
        String tempCaller = null;
        String tempCallee = null;
        String tempStart = null;
        String tempEnd = null;

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

                    if(tempName == null)
                        tempName = tempInput;
                    else if(tempCaller == null)
                        tempCaller = tempInput;
                    else if(tempCallee == null)
                        tempCallee = tempInput;
                    else if(tempStart == null)
                        tempStart = tempInput;
                    else if(tempEnd == null)
                        tempEnd = tempInput;

                    try {
                        call = new PhoneCall(tempCaller, tempCallee, tempStart, tempEnd);  // Refer to one of Dave's classes so that we can be sure it is on the classpath
                        bill = new PhoneBill(tempName, call);


                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                    tempInput = new String();
                    tempName = null;
                    tempCaller = null;
                    tempCallee = null;
                    tempStart = null;
                    tempEnd = null;
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
