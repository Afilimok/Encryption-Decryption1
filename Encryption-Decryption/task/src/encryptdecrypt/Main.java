package encryptdecrypt;//package encryptdecrypt;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static <outputFlag> void main(String[] args) throws FileNotFoundException {
        int key = 0;
        String s = "", t = "-";
        File input;
        input = null;
        File output = null;
        boolean outputFlag = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                s = args[i + 1];
            }
            if (args[i].equals("-mode")) {
                t = args[i + 1];
            }
            if (args[i].equals("-in")) input = new File(args[i + 1]);
            if (args[i].equals("-out")) {
                output = new File(args[i + 1]);
                outputFlag = true;
            }
        }
        StringBuilder res = new StringBuilder();
        if (input!= null) {
            Scanner scanner = new Scanner(input);
            s = scanner.nextLine();
        }
        switch (t) {
            case "enc":
                for (int i = 0; i < s.length(); i++) {
                    res.append((char) ((s.charAt(i) + key)));
                }

                break;
            case "dec":
                for (int i = 0; i < s.length(); i++) {
                    res.append((char) ((s.charAt(i) - key)));
                }
                break;
        }
        if (outputFlag) {
            try (FileWriter writer = new FileWriter(output)) {
                writer.write(res.toString());
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            System.out.println(res);
        }
    }
}
