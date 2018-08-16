package edu.pdx.cs410J.anturner;

import edu.pdx.cs410J.PhoneBillDumper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by an_d on 7/18/17.
 *
 * TextDumper dumps the contents of an airline (including flights)
 * to a text file.
 */
public class TextDumper implements PhoneBillDumper<PhoneBill> {


    @Override
    public void dump(PhoneBill phoneBill) throws IOException {

        try {

            String s = phoneBill.toString();

            String file = "/Users/an_d/Documents/school/2017 Summer/CS 410 - Java/git/PortlandStateJavaSummer2017/airline/src/main/java/edu/pdx/cs410J/anturner/output.txt";

            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(s);
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Success");

    }

    public void dump(PhoneBill phoneBill, String passFile){

        try {

            String s = phoneBill.toString();

            String file = "/Users/an_d/Documents/school/2017 Summer/CS 410 - Java/git/PortlandStateJavaSummer2017/airline/src/main/java/edu/pdx/cs410J/anturner/"+passFile;

            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(s);
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Success");

    }


}
