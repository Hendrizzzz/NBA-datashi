package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

    public static void readData(String filename) {
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String index : row) {
                    System.out.printf("%-25s", index);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
