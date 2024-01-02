import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static int N, M;
    public static int[] canUse, arr;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth){
        if(depth == M){
            for(int num : arr){
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        else{
            for(int i = 0; i < N; i++){
                arr[depth] = canUse[i];
                dfs(depth + 1);
            }
        }
    }

    public static void main(String[] args){
        //사용자 입력
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        canUse = new int[N];
        arr = new int[M];
        for(int i = 0; i < N; i++){
            canUse[i] = scan.nextInt();
        }

        // N개의 자연수 중에서 M개를 고른 수열 출력
        Arrays.sort(canUse);
        dfs(0);
        System.out.println(sb);
        scan.close();
    }
}