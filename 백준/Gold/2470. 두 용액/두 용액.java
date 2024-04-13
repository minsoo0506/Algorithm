import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long a, b;
    private static long minSum = Long.MAX_VALUE;
    private static long[] arr;

    public static void binarySearch(int index){
        int left = index + 1;
        int right = N - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(Math.abs(arr[index] + arr[mid]) < minSum){
                a = arr[index];
                b = arr[mid];
                minSum = Math.abs(a + b);
            }

            if(arr[index] + arr[mid] < 0){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N - 1; i++){
            binarySearch(i);
        }

        System.out.println(a + " " + b);
    }
}