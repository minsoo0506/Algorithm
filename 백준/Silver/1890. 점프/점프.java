import java.util.Scanner;

public class Main {
    public static int N;
    public static int[][] arr;
    public static long[][] dp;
    public static long findRoutes(){
        dp[0][0] = 1;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int jump = arr[i][j];
                if(jump == 0) break;
                if(i + jump < N){
                    dp[i + jump][j] += dp[i][j];
                }
                if(j + jump < N){
                    dp[i][j + jump] += dp[i][j];
                }
            }
        }

        return dp[N - 1][N - 1];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();
        arr = new int[N][N];
        dp = new long[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = scan.nextInt();
            }
            scan.nextLine();
        }

        System.out.println(findRoutes());
        scan.close();
    }
}