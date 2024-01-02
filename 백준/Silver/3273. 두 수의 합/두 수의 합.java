import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //사용자 입력
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scan.nextInt();
        }
        scan.nextLine();
        int x = scan.nextInt();

        // 문제의 조건을 만족하는 쌍의 개수 구하기
        Arrays.sort(arr);
        int count = 0;
        int start_index = 0;
        int end_index = arr.length - 1;
        while(true){
            if(start_index >= end_index) break;

            if(arr[start_index] + arr[end_index] == x){
                start_index++; end_index--;
                count++;
            }
            else if(arr[start_index] + arr[end_index] < x){
                start_index++;
            }
            else{
                end_index--;
            }
        }

        // 쌍의 개수 출력
        System.out.println(count);

        scan.close();
    }
}