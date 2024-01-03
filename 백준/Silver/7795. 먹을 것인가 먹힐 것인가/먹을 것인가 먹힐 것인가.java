import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int[] arrA = new int[N];
            for(int j = 0; j < N; j++){
                arrA[j] = scan.nextInt();
            }
            int[] arrB = new int[M];
            for(int j = 0; j < M; j++){
                arrB[j] = scan.nextInt();
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            int count = 0;
            int A_index = 0;
            int B_index = 0;
            while(A_index < arrA.length && B_index < arrB.length){
                if (arrA[A_index] > arrB[B_index]){
                    count += arrA.length - A_index;
                    B_index++;
                }else{
                    A_index++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
        scan.close();
    }
}