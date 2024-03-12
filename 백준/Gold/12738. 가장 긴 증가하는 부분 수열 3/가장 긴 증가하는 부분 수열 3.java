import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        ArrayList<Integer> LIS = new ArrayList<>(); // 증가하는 부분 수열을 담는 리스트

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for(int i = 0; i < N; i++) {
            // LIS가 비어있거나 LIS의 마지막 값이 arr[i]보다 작을 때
            if (LIS.isEmpty() || LIS.get(LIS.size() - 1) < arr[i]) {
                LIS.add(arr[i]);
            } else {
                // 이분 탐색
                int left = 0;
                int right = LIS.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;
                    // LIS의 mid(번째) 값이 arr[i]보다 크거나 같다면 right 값을 mid로 줄여주기
                    if (LIS.get(mid) >= arr[i]) {
                        right = mid;
                    } else {
                        // LIS의 mid(번째) 값이 arr[i]보다 작다면 left 값을 mid로 늘려주기
                        left = mid + 1;
                    }
                }

                LIS.set(right, arr[i]);
            }
        }

        System.out.println(LIS.size());
    }
}