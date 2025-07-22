import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][2];
        long count = 0; // 결과를 저장

        // n이 3보다 작을 경우, n=1일 때 1, n=2일 때 10 밖에 케이스가 없으므로 count는 1
        if(n < 3){
            count = 1;
        }
        else {
            // n이 2일 때, 10 이므로 마지막 자리에는 0밖에 오지 못함
            dp[2][0] = 1;
            dp[2][1] = 0;
            for (int i = 3; i <= n; i++) {
                dp[i][0] += (dp[i - 1][0] + dp[i - 1][1]); // 마지막 자리가 0이라면 앞에서 1이나 0 둘다 나올 수 있음
                dp[i][1] += dp[i - 1][0]; // 마지막 자리가 1이라면 앞에서 0만 나올 수 있음
            }

            count = dp[n][0] + dp[n][1];
        }

        bw.write(count + "");

        bw.flush();
        bw.close();
        br.close();
    }
}