import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] used;

    public static void dfs(int depth){
        if(depth == M){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        else {
            for (int i = 1; i <= N; i++) {
                if(!used[i]){
                    used[i] = true;
                    arr[depth] = i;
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
        arr = new int[M];
        used = new boolean[N+1];

        dfs(0);
        scan.close();
    }
}