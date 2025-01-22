package util;


public class AppPrompter {

    public static String position() {
        while (true) {
            System.out.print("Position (pg, sg, sf, pf, c): ");
            String chosenPosition = InputReader.readString();

            if (    chosenPosition.equalsIgnoreCase("pg") || chosenPosition.equalsIgnoreCase("sg") ||
                    chosenPosition.equalsIgnoreCase("sf") || chosenPosition.equalsIgnoreCase("pf") ||
                    chosenPosition.equalsIgnoreCase("c") )
                return chosenPosition;
            else System.out.println("Error: Invalid position. Try again. ");
        }
    }

    public static int intWithMessage(String prompt) {
        while (true) {
            System.out.print(prompt);
            int age = InputReader.readInteger();

            if (age < 0)
                System.out.println("Error: Cannot be a negative integer. Try again");
            else return age;
        }
    }


    public static String stringWithMessage(String message) {
        System.out.print(message);
        return InputReader.readString();
    }


    public static boolean isAscending() {
        while (true) {
            System.out.print("Sort in Ascending (A) or Descending (D) order? Please type A or D. ");
            String choice = InputReader.readString();

            if (choice.equalsIgnoreCase("A")) return true;
            else if (choice.equalsIgnoreCase("D")) return false;
            else System.out.println("Invalid input. Try again.  ");
        }
    }
}
