import java.util.*;
import java.io.*;

public class Main {
    private static final int MOD = 10007;
    public static int count(int n){
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % MOD;
        }

        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(count(n));
    }
}