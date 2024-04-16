// 백준 233337 Drunk Passenger(기존 문제의 변형)
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double N = Integer.parseInt(br.readLine());

        // (N이 2일 때) 첫 번째 승객은 무조건 자신의 좌석에 앉지 않으므로,
        // 마지막 탑승자가 탑승할 때 그 자리에 다른 탑승자가 앉아있을 확률은 1
        if(N == 2){
            System.out.println(1);
            return;
        }

        // 첫 번째 승객의 행동이 다른 모든 승객의 행동에 영향을 미치기 때문에 첫 번째 승객의 확률만 고려.

        // 첫 번째 승객이 마지막 승객의 좌석에 앉을 확률은 1/(n-1).
        // 이 경우, 마지막 승객은 자신의 좌석에 앉을 수 없으므로, 마지막 승객의 좌석에 다른 사람이 앉아 있을 확률은 1.

        // 첫 번째 승객이 마지막 승객의 좌석이 아닌, 다른 승객의 좌석에 앉을 확률은 (n-2)/(n-1).
        // 이 경우, 그 승객은 다른 사람의 좌석 또는 첫 번째 승객의 좌석 중 하나에 앉을 것이기 때문에, 마지막 승객이 자신의 좌석에 앉을 확률은 여전히 1/2.
        // 승객이 첫 번째 승객의 좌석을 제외한 다른 곳에 앉더라도 1/2이라는 확률이 계속해서 위임됨.

        // 따라서 마지막 승객의 좌석에 다른 승객이 앉아있을 확률은 다음과 같다.
        // P(A ∩ B) = P(A)P(B)
        double result = (1 / (N - 1) * 1) + ((N - 2) / (N - 1) * 1 / 2);
        System.out.println(result);
    }
}