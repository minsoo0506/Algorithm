import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] arr;
    public static ArrayList<String> list;
    public static StringBuilder sb;

    // 백트래킹으로 풀이
    public static void dfs(int depth, int start){
        if(depth == M) {
            list.add(sb.toString());
            return;
        }

        int lastUsed = -1; // 마지막으로 사용된 숫자를 추적(중복 방지)
        for (int i = start; i < N; i++) {
            if (lastUsed != arr[i]) { // 이전에 사용된 숫자와 다를 경우에만 진행
                int lengthBeforeAppend = sb.length(); // 현재 StringBuilder의 길이 저장
                sb.append(arr[i]).append(" ");
                dfs(depth + 1, i + 1);
                sb.setLength(lengthBeforeAppend); // 재귀 호출 후 StringBuilder를 이전 상태로 되돌림
                lastUsed = arr[i]; // 마지막으로 사용된 숫자 업데이트
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        list = new ArrayList<>();

        sb = new StringBuilder();
        dfs(0, 0);

        for(String s : list){
            System.out.println(s);
        }

        br.close();
    }
}