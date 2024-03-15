import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1]; // 최소 연산 횟수를 저장하는 dp 배열
        int[] path = new int[N + 1]; // 1로 만드는 방법에 포함되어 있는 수를 저장하는 배열

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;
            
            // i가 2로 나누어 떨어지는 경우, 1을 빼는 것보다 최소 연산인지 확인
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }
            
            // i가 3으로 나누어 떨어지는 경우, 1을 빼는 것보다 최소 연산인지 확인
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
        }
        
        // 연산을 하는 횟수의 최솟값 출력
        System.out.println(dp[N]);

        // N을 1로 만드는 방법 출력
        Queue<Integer> queue = new LinkedList<>();
        for (int i = N; i != 0; i = path[i]) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}