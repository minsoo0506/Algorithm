import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        int[][] dp = new int[N][3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = MAX;
        for(int firstColor = 0; firstColor < 3; firstColor++) {
            for(int i = 0; i < 3; i++){
                if(firstColor == i) dp[0][i] = cost[0][i];
                else dp[0][i] = MAX;
            }

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for(int i = 0; i < 3; i++){
                if(i == firstColor) continue;
                result = Math.min(result, dp[N - 1][i]);
            }
        }

        System.out.println(result);
    }
}