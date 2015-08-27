public class BubbleSort {

    public static void main(String[] args) {
        int[]arr = {189,100,80,5,67,3,0};
        process(arr, arr.length-1);
    }

    /*
    * implementation only for integers
    * */
    private static void process(int[] arr, int endIndex) {
        if (endIndex == 0) return;
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length-1 && arr[i+1] < arr[i]){
                int a = arr[i];
                int b = arr[i+1];
                arr[i] = b;
                arr[i+1] = a;
            }
        }
        System.out.println();
        for (int i : arr) {
            System.out.print("[" + i + "]");
        }
        process(arr,endIndex-1);
    }


}
