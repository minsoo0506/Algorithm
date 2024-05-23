// 백준 1931 회의실 배정
// 정렬, 그리디 알고리즘
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2]; // 회의실 사용 시간 {회의 시작 시간, 회의 종료 시간}


        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        // 각 회의를 먼저 종료 시간으로, 그 다음으로 시작 시간으로 정렬
        Arrays.sort(meeting, (a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        int meetingCount = 0;
        int end = -1;
        for(int[] m : meeting){
            // 현재 회의가 이전 회의가 끝난 후에 시작하는지 확인
            if(m[0] >= end){
                end = m[1]; // 회의의 종료 시간을 기록
                meetingCount++;
            }
        }

        System.out.println(meetingCount);
    }
}