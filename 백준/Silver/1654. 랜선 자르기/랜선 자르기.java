import java.util.Scanner;

public class Main {
    public static long getCount(int[] arr, long n){
        long count = 0;

        for(int i = 0; i < arr.length; i++){
            count += (arr[i] / n);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[]arr = new int[N];
        long max = 0;

        for(int i = 0; i < N; i++){
            arr[i] = scan.nextInt();
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        long left = 1;
        long right = max;

        while(left <= right){
            long mid = (left + right) / 2;

            if(getCount(arr, mid) < K){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }
}