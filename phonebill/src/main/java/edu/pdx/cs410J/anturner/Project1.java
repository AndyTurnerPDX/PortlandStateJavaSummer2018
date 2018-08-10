package edu.pdx.cs410J.anturner;

/**
 * The main class for the CS410J Phone Bill Project
 *
 * Project1 should contain main method that parse the command line,
 * creates a PhoneBill and a PhoneCall as specified by the command line,
 * adds the PhoneCall to the PhoneBill, and optionally prints a description
 * of the PhoneCall returned by its toString method.
 *
 */
public class Project1 {


    /**
     *
     * @param args are the arguments being passed in an on to temp variables.
     *             If valid the program will pass them onto phonecall and phonebill constructor
     *
     *
     */
    public static void main(String[] args) {

        String[] readMe = new String[9];
        readMe[0] = "This is a Phone Bill Application:";
        readMe[1] = "It is meant to help you keep track of the phone calls you have with another subscriber";
        readMe[2] = "The details to be provided for each phone call should be...";
        readMe[3] = "Your phone number, the number of the caller you're reaching out to.";
        readMe[4] = "The date and time of when the phone call started";
        readMe[5] = "And the date and time of when the phone call ended.";
        readMe[6] = "If you would like to see the results of your input add the argument -print";
        readMe[7] = "If any input you have provided is invalid you will recieve and error message";
        readMe[8] = "Happy dialing!";

        String tempName = null;
        String tempCaller = null;
        String tempCallee = null;
        String tempStart = null;
        String tempEnd = null;

        boolean readMeFlag = false;
        boolean printFlag = false;

        PhoneCall call;     // Refer to one of Dave's classes so that we can be sure it is on the classpath

        PhoneBill bill;

        if(args.length == 0) {
            System.err.println("Missing command line arguments");
            System.exit(0);
        }

        for(String a : args){
            if(a.charAt(0) == '-') {
                if (a.contains("readme"))
                    readMeFlag = true;
                else if (a.contains("print"))
                    printFlag = true;
                else
                    System.err.println("Invalid Comand Line Argument");
            }
            else {

                if(tempName == null)
                    tempName = a;
                else if(tempCaller == null)
                    tempCaller = a;
                else if(tempCallee == null)
                    tempCallee = a;
                else if(tempStart == null)
                    tempStart = a;
                else if(tempEnd == null)
                    tempEnd = a;
                else {
                    System.err.println("Invalid Comand Line Argument");
                    System.exit(0);
                }
            }


        }

        if(readMeFlag == true){
            for (String r : readMe)
                System.out.println(r);
        }

        try {
            call = new PhoneCall(tempCaller, tempCallee, tempStart, tempEnd);  // Refer to one of Dave's classes so that we can be sure it is on the classpath
            bill = new PhoneBill(tempName, call);

            if(printFlag == true)
                bill.print();

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        System.exit(1);
    }

}