import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] canUse;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int v, int depth){
        if(depth == M){
            for(int num : arr){
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        else{
            for(int i = v; i < N; i++){
                arr[depth] = canUse[i];
                dfs(i + 1, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        scan.nextLine();
        canUse = new int[N];
        arr = new int[M];
        for(int i = 0; i < N; i++){
            canUse[i] = scan.nextInt();
        }
        Arrays.sort(canUse);

        dfs(0, 0);
        System.out.print(sb);
        scan.close();
    }
}