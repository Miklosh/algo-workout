import java.util.ArrayList;
import java.util.List;

public class ISBN {

    private static final String ISBN_1 = "ISBN: 4-08-858734";
    private static final String ISBN_2 = "ISBN: 4-08-872271";
    private static final String ISBN_3 = "ISBN: 4-08-873104";

    public static void main(String[] args) {
        process(ISBN_1);
        process(ISBN_2);
        process(ISBN_3);
    }

    private static void process(String isbn) {
        // parse string and clean it from unnecessary info
        // get all the numbers into list
        // get sum of multiplication all numbers to their indexes
        // perform % operation and print the result

        String trimISBN = isbn.substring(5).trim();

        int multiSum = 0;
        int counter = 1;

        for (char c : trimISBN.toCharArray()) {
            String b = "" + c;
            if (b.matches("[0-9]")) {
                multiSum += Integer.parseInt(b) * counter;
                counter++;
            }
        }

        int checkNumber = multiSum % 11;
        String finalISBN = isbn + "-" + checkNumber;
        System.out.println(finalISBN);
    }

}
