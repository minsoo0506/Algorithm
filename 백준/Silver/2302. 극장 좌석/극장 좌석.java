import java.io.*;

public class Main {
    public static int fibo(int n){

        if(n < 2) return 1;

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int result = 1;
        if(m > 0) {
            int fixedSeat[] = new int[m];

            for (int i = 0; i < m; i++) {
                fixedSeat[i] = Integer.parseInt(br.readLine());
            }
            
            for (int i = 0; i < m; i++) {
                if (i == 0)
                    result *= fibo(fixedSeat[i] - 1);
                else
                    result *= fibo(fixedSeat[i] - fixedSeat[i - 1] - 1);
            }
            result *= fibo(n - fixedSeat[m - 1]);
        }
        else {
            result = fibo(n);
        }
        
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}