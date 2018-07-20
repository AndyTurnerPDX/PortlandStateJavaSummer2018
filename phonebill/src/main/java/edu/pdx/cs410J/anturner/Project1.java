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

        PhoneCall call = new PhoneCall();  // Refer to one of Dave's classes so that we can be sure it is on the classpath

        PhoneBill bill = new PhoneBill();

        if(args.length < 4){
            System.err.println("Missing command line arguments");
            System.exit(1);
        }
        if(args[0] != null){
            bill.setCustomerName(args[0]);
        }
        if(args[1] != null){

        }
        if(args[2] != null){

        }
        if(args[3] != null){

        }
        if(args[5] != null){
            if(args[5].contains("-p")) {
                bill.print();
            }
            if(args[5].contains("-r")){
                System.out.println("Read Me Command");
            }
        }
        if(args[6] != null){
            if(args[6].contains("-p")) {
                bill.print();
            }
            if(args[6].contains("-r")){
                System.out.println("Read Me Command");
            }
        }

        for(String arg : args)
            System.out.println(arg);
        System.exit(1);
    }

}