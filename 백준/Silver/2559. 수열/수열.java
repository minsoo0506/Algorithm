import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //사용자 입력
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scan.nextInt();
        }

        // K일 동안의 온도의 최대 합 구하기
        int max = Integer.MIN_VALUE;
        int start_index = 0;
        int end_index = start_index + K;
        while(end_index <= arr.length){
            int sum = 0;
            for(int i = start_index; i < end_index; i++){
                sum += arr[i];
            }
            if(sum > max){
                max = sum;
            }
            start_index++;
            end_index++;
        }

        System.out.println(max);
        scan.close();
    }
}