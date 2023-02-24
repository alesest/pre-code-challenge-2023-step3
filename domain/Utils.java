package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Utils {


    static public List<List<String>> tokens(List<String> in) {

        return in.stream().map(s -> {
            StringTokenizer tokenizer = new StringTokenizer(s, " ");
            List<String> inn = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                inn.add(token);
            }
            return inn;
        }).collect(Collectors.toList());

    }

    static public List<String> readFile(String filename) {
        try {
            ArrayList<String> ret = new ArrayList<>();
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                ret.add(data);
            }
            scanner.close();
            return ret;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred reading file.");
            e.printStackTrace();
            return null;
        }
    }

    static public void writeFile(String filename, String... lines) {
        try {
            File file = new File(filename);
            if (file.createNewFile()) {
                FileWriter writer = new FileWriter(filename);
                for (String line : lines) {
                    writer.write(line + "\n");
                }
                writer.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred writing file.");
            e.printStackTrace();
        }
    }

}
