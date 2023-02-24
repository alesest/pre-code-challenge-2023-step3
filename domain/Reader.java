package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Reader {


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

}
