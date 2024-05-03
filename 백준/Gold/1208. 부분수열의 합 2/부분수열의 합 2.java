// 백준 1208 부분수열의 합 2 : 중간에서 만나기 알고리즘
// 2^N의 복잡도를 2 * 2^(N / 2)로 낮추는 방법(기존의 시간 복잡도를 절반으로 줄이는 방법)
import java.io.*;
import java.util.*;

public class Main {
    // N은 수열의 길이, S는 찾고자 하는 부분수열의 합
    private static int N, S;
    // arr는 입력받은 수열을 저장하는 배열
    private static long[] arr;
    // map은 부분수열의 합을 키로, 그 합을 가지는 부분수열의 개수를 값으로 저장하는 맵
    private static Map<Long, Long> map;
    // count는 합이 S가 되는 부분수열의 개수
    private static long count;

    // 배열의 오른쪽 부분을 탐색하는 함수
    public static void rightSearch(int mid, long partialSum){
        // mid가 배열의 끝에 도달하면
        if(mid == N){
            // map에 partialSum을 키로, 그 횟수를 값으로 저장
            map.put(partialSum, map.getOrDefault(partialSum, 0l) + 1);
            return;
        }
        // mid번째 요소를 포함하지 않는 경우
        rightSearch(mid + 1, partialSum);
        // mid번째 요소를 포함하는 경우
        rightSearch(mid + 1, partialSum + arr[mid]);
    }

    // 배열의 왼쪽 부분을 탐색하는 함수
    public static void leftSearch(int start, long partialSum){
        // start가 배열의 중간에 도달하면
        if(start == N / 2){
            // map에 (S - partialSum)이 있는지 확인하고, 있으면 그 횟수를 count에 더함
            if(map.containsKey(S - partialSum)){
                count += map.get(S - partialSum);
            }
            return;
        }
        // start번째 요소를 포함하지 않는 경우
        leftSearch(start + 1, partialSum);
        // start번째 요소를 포함하는 경우
        leftSearch(start + 1, partialSum + arr[start]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수열의 길이 N과 찾고자 하는 부분수열의 합 S를 입력받음
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        // 수열의 길이 N만큼 배열 arr을 초기화
        arr = new long[N];

        // 수열의 각 요소를 입력받음
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        // 합이 S가 되는 부분수열의 개수를 저장하는 count를 0으로 초기화
        count = 0;
        // 부분수열의 합을 저장하는 map을 초기화
        map = new HashMap<>();
        // 배열의 오른쪽 부분을 먼저 탐색
        rightSearch(N / 2, 0);
        // 그 다음 왼쪽 부분을 탐색
        leftSearch(0, 0);

        // S가 0인 경우, 공집합을 제외하기 위해 count에서 1을 뺌
        // count가 0보다 큰 경우에만 공집합을 제외함
        System.out.println(S == 0 && count > 0 ? count - 1 : count);
    }
}