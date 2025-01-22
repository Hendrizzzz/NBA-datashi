package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {


    private static final BufferedReader INPUT_READER = new BufferedReader(new InputStreamReader(System.in));


    private InputReader() {

    }

    public static int readInteger() {
        while (true)
            try {
                return Integer.parseInt(INPUT_READER.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a valid number. Try again. ");
            } catch (IOException e) {
                System.out.println("Error: An unexpected issue occurred while reading your input. Please try again.");
            }
    }


    public static int readIntegerInRange(int min, int max) {
        while (true)
            try {
                int choice = Integer.parseInt(INPUT_READER.readLine());

                if (choice < min || choice > max)
                    System.out.println("Error: Please enter a number between " + min + " and " + max + ". ");
                else return choice;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a valid number. Try again. ");
            } catch (IOException e) {
                System.out.println("Error: An unexpected issue occurred while reading your input. Please try again.");
            }
    }



    public static String readStringFromMenuChoice(int numberOfChoicesFromSmallLetterA) {
        while (true)
            try {
                String input = INPUT_READER.readLine().trim();

                if (input.length() == 1 && input.charAt(0) >= 'a' && input.charAt(0) <= 'a' + numberOfChoicesFromSmallLetterA - 1)
                    return input;
                else
                    System.out.println("Invalid input. Please enter a valid choice (between 'a' and " + (char) ('a' + numberOfChoicesFromSmallLetterA - 1) + " only). Try again. ");

            } catch (IOException e) {
                System.out.println("Error: An unexpected issue occurred while reading your input. Please try again.");
            }
    }



    public static String readString() {
        while (true)
            try {
                return INPUT_READER.readLine();
            } catch (IOException e) {
                System.out.println("Error: An unexpected issue occurred while reading your input. Please try again.");
            }
    }


}
