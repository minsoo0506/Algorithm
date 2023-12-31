import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] canUse;
    static int[] arr;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth){
        if(depth == M){
            for(int num : arr){
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        else{
            for(int i = 0; i < N; i++){
                if(!used[i]){
                    used[i] = true;
                    arr[depth] = canUse[i];
                    dfs(depth + 1);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        scan.nextLine();
        canUse = new int[N];
        used = new boolean[N];
        arr = new int[M];
        for(int i = 0; i < N; i++){
            canUse[i] = scan.nextInt();
        }
        Arrays.sort(canUse);

        dfs(0);
        System.out.print(sb);
        scan.close();
    }
}