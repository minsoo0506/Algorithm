import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][]dp = new int[15][15];

        // 0층에 i호에 살고 있는 사람 구하기
        for(int i = 1; i <= 14; i++){
            dp[0][i] = i;
        }

        // 1층부터 14층까지 각 층의 j호에 살고 있는 사람 구하기
        for(int i = 1; i <= 14; i++){
            for(int j = 1; j <= 14; j++){
                for(int k = 1; k <= j; k++){
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[k][n]).append("\n");
        }

        br.close();
        System.out.print(sb);
    }
}