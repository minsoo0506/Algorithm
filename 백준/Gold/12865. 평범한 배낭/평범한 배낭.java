import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] w = new int[N];
        int[] v = new int[N];
        int[][] dp = new int[N + 1][K + 1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        // 물건을 1개부터 N개까지 넣어보기
        for(int i = 1; i <= N; i++){
            // 무게 제한을 1부터 K까지 늘려가기
            for(int j = 1; j <= K; j++){
                if(w[i - 1] <= j){
                    // 배낭에 물건을 넣는 것과 넣지 않는 것 중에 무게 j를 넘지 않으면서 최대인 가치 구하기
                    dp[i][j] = Math.max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
                } else {
                    // 물건을 넣었을 때 무게 j를 초과하는 경우
                    dp[i][j] = dp[i - 1][j];
                }

                // 최대 가치 값 갱신
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}
