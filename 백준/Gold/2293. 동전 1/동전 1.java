import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[101]; // (1 ≤ n ≤ 100)
        int[] dp = new int[10001]; // (1 ≤ k ≤ 10,000)
        for(int i = 1; i <= n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1; // 한 코인을 가지고 그 코인의 가치만큼 만들 수 있는 경우의 수
        for(int i = 1; i <= n; i++){
            for(int j = coin[i]; j <= k; j++){
                /*
                (일반항)
                j만큼의 가치를 만들기 위한 경우의 수 : 
                j에서 i번째 코인(현재 코인)의 가치를 뺐을 때의 경우의 수를 dp 배열에 누적해서 더해준다 
                */
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);
    }
}