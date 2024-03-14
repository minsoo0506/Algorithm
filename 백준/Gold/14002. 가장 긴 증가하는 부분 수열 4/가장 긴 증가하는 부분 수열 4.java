import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int lis = 1;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    lis = Math.max(lis, dp[i]);
                }
            }
        }
        br.close();

        sb.append(lis).append("\n");

        Stack<Integer> stack = new Stack<>();
        for(int i = N - 1; i >= 0; i--){
            if(lis == dp[i]){
                stack.push(arr[i]);
                lis--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}