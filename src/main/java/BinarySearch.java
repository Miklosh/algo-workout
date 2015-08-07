/*http://interactivepython.org/runestone/static/pythonds/index.html*/

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[10];
        fillArrayWithTestvalues(arr);
        performSearch(arr, arr.length - 1, 3);
    }

    public static boolean performSearch(int[] arr, int thresholdPosition, int searchItem) {

        if (arr.length == 0) return false;
        if (searchItem > arr.length) return false;

        // check for odd length of array
//      if arr.length == 2 then use sequential search?
        if (searchItem == arr[thresholdPosition]) {
            return true;
        } else if (searchItem > arr[thresholdPosition]) {
            thresholdPosition = thresholdPosition / 2;
            return performSearch(arr, thresholdPosition, searchItem);
        } else {
            thresholdPosition = thresholdPosition / 2;
            return performSearch(arr, thresholdPosition, searchItem);
        }

    }

    private static void fillArrayWithTestvalues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }


}
