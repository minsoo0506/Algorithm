// 백준 2470 두 용액 : 이분탐색으로 풀이
// - 투포인터가 조금 더 효율적
import java.io.*;
import java.util.*;

public class Main {
    private static int N; // 전체 용액의 수
    private static long a, b; // 용액1과 용액2의 특성값(출력해야 하는 두 개의 값)
    private static long minSum = Long.MAX_VALUE; // 최소인 특성값의 합
    private static long[] arr; // 용액의 특성값을 저장하는 배열

    // 이분 탐색을 수행하는 메소드
    public static void binarySearch(int index){
        int left = index + 1;
        int right = N - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            // 두 용액 특성값의 합(절댓값)이 minSum보다 작다면
            // 두 용액의 특성값, minSum 최신화
            if(Math.abs(arr[index] + arr[mid]) < minSum){
                a = arr[index];
                b = arr[mid];
                minSum = Math.abs(a + b);
            }

            // 범위 조정
            if(arr[index] + arr[mid] < 0){
                // 두 특성값의 합이 0보다 작다면 범위의 왼쪽을 증가시킴
                left = mid + 1;
            } else {
                // 두 특성값의 합이 0보다 크거나 같다면 범위의 오른쪽을 감소시킴
                right = mid - 1;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        // 이분 탐색을 위한 배열 정렬
        Arrays.sort(arr);

        // 이분 탐색 수행
        for(int i = 0; i < N - 1; i++){
            binarySearch(i);
        }

        // 두 용액의 특성값을 오름차순으로 출력
        System.out.println(a + " " + b);
    }
}
