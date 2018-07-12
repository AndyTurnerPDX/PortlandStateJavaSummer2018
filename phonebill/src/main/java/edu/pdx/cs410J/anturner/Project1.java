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

    if(args.length == 0){
      System.err.println("Missing command line arguments");
      System.exit(1);
    }

    /**
     * Parses command line for appropriate format
     */
    //parseCommandLine(args);

    int i = 0;
    for (String arg : args) {
      System.out.println(i + arg);
      i++;
    }
    System.exit(1);
  }

  /**
   *
   * @param args
   *
   * Parses command line for appropriate arguments with valid syntax
   *
   */
//  private static void parseCommandLine(String[] args) {
//
//    /**
//     * Check if valid arguments
//     */
//    if(!args[0].contains("-p")) {
//      System.err.println("Invalid command line arguments");
//      System.exit(1);
//    }
//
//
//
//
//  }

}