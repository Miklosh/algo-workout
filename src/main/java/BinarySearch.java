/*http://interactivepython.org/runestone/static/pythonds/index.html*/

import java.util.*;

public class BinarySearch {

    static boolean isFound = false;

    public static void main(String[] args) {
        Integer[] arr = new Integer[100];
        fillArrayWithTestvalues(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(performSearch(arr, i));
        }
    }

    public static boolean performSearch(Integer[] arr, int searchItem) {

        if (searchItem > arr[arr.length - 1] || searchItem < 0)
            return isFound;

        if (searchItem == arr[0] || searchItem == arr[arr.length - 1] || searchItem == arr[arr.length / 2]) { // bad
            isFound = true;
            return true;
        }

        if (searchItem > arr[arr.length / 2]) {
            performSearch(Arrays.copyOfRange(arr, arr.length / 2, arr.length - 1), searchItem);
        } else {
            performSearch(Arrays.copyOfRange(arr, 0, arr.length / 2), searchItem);
        }

        return isFound;

    }

    private static void fillArrayWithTestvalues(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

}
