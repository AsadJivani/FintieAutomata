/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REAssignment;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author asadj
 */
public class MuhammadAsadB15101064 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Pattern Id = Pattern.compile("_[A-Za-z0-9]+|[A-Za-z][A-Za-z0-9]*");
        Pattern Char = Pattern.compile("'((\\\\('|\\\\|\"|[tnrbo]))|([tnbro])|([^tnbro\"]))'");
        Pattern Str = Pattern.compile("\"((\\\\('|\\\\|\"|[tnrbo]))|([tnbro])|([^tnbro\"]))*\"");
        Pattern Int = Pattern.compile("[+-]?[0-9]+");
        Pattern Float = Pattern.compile("[+-]?[0-9]*[.][0-9]+([eE]?[-+]?[0-9]+)");

        String check = null;

        do {

            String query = input.next();

            if (matcher(Id, query)) {
                System.out.println("IDENTIFIER");
            } else if (matcher(Char, query)) {
                System.out.println("CHARACTER CONSTANT");
            } else if (matcher(Int, query)) {
                System.out.println("INTEGER CONSTANT");
            } else if (matcher(Float, query)) {
                System.out.println("FLOAT CONSTANT");
            } else if (matcher(Str, query)) {
                System.out.println("STRING CONSTANT");
            } else {
                System.out.println("INVALID");
            }

            System.out.println("DO YOU WANT TO CONTINUE? (Y/N)");
            check = input.next();
        } while (check.equals("y") || check.equals("Y"));

    }

    public static boolean matcher(Pattern regex, String input) {

        Matcher match = regex.matcher(input);
        return match.matches();

    }

}
