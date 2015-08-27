public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {5,100,376,1,93,1347};
        process(arr);
    }

    private static void process(int[]arr) {
        algo(arr,0);
    }

    private static void algo(int[]arr, int startIdx) {

        if (startIdx == arr.length) return;

        int min = arr[startIdx];
        int minI = startIdx;
        for (int i = startIdx; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minI = i;
            }
        }

        if (min == arr[startIdx]) return;

        int startV = arr[startIdx];
        arr[startIdx] = arr[minI];
        arr[minI] = startV;
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] +"]");
        }
        System.out.println();
        algo(arr,startIdx+1);
    }

}
