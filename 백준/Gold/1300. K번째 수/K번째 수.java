// 백준 1300 : 브루트포스로 풀이 시, 시간 초과 이전에 메모리 초과 발생. 이분 탐색으로 풀이해야 함.
// B[K] = x 에서 K 인덱스 원소 값 x를 찾는 것이 아닌,
// x의 값을 조정해 나가면서 (K값과 같아지는) x보다 작거나 같은 원소의 개수를 찾는 것
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // (10^5보다 작거나 같은 자연수)
        long K = Long.parseLong(br.readLine()); // min(10^9, N^2)보다 작거나 같은 자연수

        long low = 1; // 하한
        long high = (long) N * N; // 상한
        long result = 0;
        while(low <= high){
            long mid = (low + high) / 2;
            long count = 0;

            /*
            구구단의 원리 사용.(행렬의 각 원소값은 i*j이기 때문)
            x보다 작거나 같은 수의 개수를 찾고 싶다면,
            1부터 N까지 반복문을 돌며 x를 i로 나누었을 때의 몫을 누적해서 더해주면 된다.
            단, 한 행에서 x보다 작거나 같은 수는 행의 최대 크기인 N을 넘을 수 없으므로,
            x/i를 한 값과 N 중에 더 작은 값을 누적합을 저장하는 변수에 저장해주면 된다.
            */
            for(int i = 1; i <= N; i++){
                count += Math.min(mid / i, N);
            }

            // 탐색 범위 조정
            if(count < K){
                // low = mid || high = mid 가 아닌 이유 : 무한 루프 방지
                // 단, 찾고자 하는 값이 여러 개 있고 그 중 가장 먼저 나타내는 위치를 찾는 경우에는 예외.
                low = mid + 1;
            } else {
                high = mid - 1;
                result = mid;
            }
        }

        System.out.println(result);
    }
}