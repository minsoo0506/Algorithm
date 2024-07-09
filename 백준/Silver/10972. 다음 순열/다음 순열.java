// 다음 순열 알고리즘
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static boolean nextPermutation(int[] arr){
        int i = arr.length - 2;
        while(i >= 0 && arr[i] >= arr[i + 1]) i--;

        if(i < 0) return false;

        int j = arr.length - 1;
        while(arr[j] <= arr[i]) j--;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverse(arr, i + 1, arr.length - 1);
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(nextPermutation(arr)){
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }

        br.close();
    }
}