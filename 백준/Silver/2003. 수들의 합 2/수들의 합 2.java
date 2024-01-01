import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        scan.nextLine();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = scan.nextInt();
        }

        int count = 0;
        int start = 0;
        int end = 0;
        while(start < arr.length && end < arr.length){
            int sum = 0;
            for(int i = start; i <= end; i++){
                sum += arr[i];
            }

            if(sum == M){
                count++;
                start++;
                end++;
            }
            else if(sum < M){
                end++;
            }
            else{
                start++;
            }
        }
        System.out.println(count);
        scan.close();
    }
}