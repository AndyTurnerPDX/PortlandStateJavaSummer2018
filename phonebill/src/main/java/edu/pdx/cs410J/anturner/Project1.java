package edu.pdx.cs410J.anturner;

import java.util.Scanner;

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

    public static void main(String[] args) {

        String tempName = null;
        String tempCaller = null;
        String tempCallee = null;
        String tempStart = null;
        String tempEnd = null;

        PhoneCall call;     // Refer to one of Dave's classes so that we can be sure it is on the classpath

        PhoneBill bill;

        if(args.length == 1){
            if(args[0].contains("-R"))
                System.out.println("This is a PhoneBook Application");
        }
        else if(args.length < 4){
            System.err.println("Missing command line arguments");
            System.exit(1);
        }
        else if(args.length >= 5){

            if(args[0] != null){
                tempName = args[0];
            }
            if(args[1] != null){
                tempCaller = args[1];
            }
            if(args[2] != null){
                tempCallee = args[2];
            }
            if(args[3] != null){
                tempStart = args[3];
            }
            if(args[4] != null){
                tempEnd = args[4];
            }

            call = new PhoneCall(tempCaller, tempCallee, tempStart, tempEnd);  // Refer to one of Dave's classes so that we can be sure it is on the classpath

            bill = new PhoneBill(tempName, call);


            if (args.length >= 6) {
                if (args[5] != null) {
                    if (args[5].contains("-p")) {
                        bill.print();
                    }
                    if (args[5].contains("-r")) {
                        System.out.println("This is a PhoneBook Application");
                    }
                }
                if(args.length >= 6){
                    if (args[6] != null) {
                        if (args[6].contains("-p")) {
                            bill.print();
                        }
                        if (args[6].contains("-r")) {
                            System.out.println("This is a PhoneBook Application");
                        }
                    }
                }
            }
        }

//        for(String arg : args)
//            System.out.println(arg);
        System.exit(1);
    }

}