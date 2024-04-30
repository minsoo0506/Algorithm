import java.io.*;

public class Main {
    private static int[][] dp;
    private static int n, m;
    private static String inputA, inputB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        inputA = br.readLine();
        inputB = br.readLine();
        n = inputA.length();
        m = inputB.length();

        dp = new int[n + 1][m + 1];
        int result = lcsLength();

        StringBuilder sb = new StringBuilder();
        while (n != 0 && m != 0) {
            if (inputA.charAt(n - 1) == inputB.charAt(m - 1)) {
                sb.insert(0, inputA.charAt(n - 1));
                n--; m--;
            } else if (dp[n][m] == dp[n - 1][m]) {
                n--;
            } else if (dp[n][m] == dp[n][m - 1]) {
                m--;
            }
        }
        bw.write(result + "\n" + sb.toString());
        bw.flush();
    }

    private static int lcsLength() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (inputA.charAt(i - 1) == inputB.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}