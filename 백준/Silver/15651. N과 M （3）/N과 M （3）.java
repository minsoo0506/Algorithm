import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth){
        if(depth == M){
            for(int num : arr){
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }
        else{
            for(int i = 1; i <= N; i++){
                arr[depth] = i;
                dfs(depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[M];

        dfs(0);
        System.out.println(sb);
        scan.close();
    }
}
