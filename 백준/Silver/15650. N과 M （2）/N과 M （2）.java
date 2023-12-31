import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;

    public static void dfs(int v, int depth){
        if(depth == M){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        else{
            for(int i = v; i <= N; i++){
                arr[depth] = i;
                dfs(i + 1, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[M];

        dfs(1, 0);
        scan.close();
    }
}