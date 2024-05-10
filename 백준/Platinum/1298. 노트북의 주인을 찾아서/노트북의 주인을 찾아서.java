// 백준 1298 노트북의 주인을 찾아서
// 이분 매칭 : dfs(재귀)로 풀이
import java.io.*;
import java.util.*;

public class Main {
    private static int N, M; // 노트북을 구입한 사람의 수, 노트북 예상 개수
    private static int[] matchedStudent; // 노트북 주인의 번호를 저장하는 배열
    private static boolean[] visit; // 방문 여부를 체크하는 배열
    private static ArrayList<Integer>[] graph; // 사람과 노트북의 연결 관계를 저장(인덱스는 학생 번호)
    private static int result; // 최대로 만족될 수 있는 사람의 수

    public static boolean dfs(int studentNum){
        if(visit[studentNum]) return false; // 이미 처리된 학생이면 false 반환
        else visit[studentNum] = true; // 처리되지 않은 학생이라면 true 저장 후 나머지 로직 수행

        // studentNum번 학생의 노트북이라고 생각되는 노트북들을 확인
        for(int next : graph[studentNum]){
            // 아직 주인을 찾지 못한 노트북이거나 노트북을 가진 학생이 다른 노트북을 가질 수 있는 경우
            // (matchedStudent[next]번 학생이 studentNum번 학생에게 양보해 줄 수 있는 경우)
            if(matchedStudent[next] == -1 || dfs(matchedStudent[next])){
                matchedStudent[next] = studentNum;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matchedStudent = new int[N + 1];
        graph = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            matchedStudent[i] = -1; // i번 노트북 주인을 -1번으로 초기화(매칭된 학생 X)
            graph[i] = new ArrayList<>();
        }

        // 이분 그래프 형성
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        result = 0;
        for(int i = 1; i <= N; i++){
            // 각 학생이 노트북을 찾는 과정이 독립적이기 때문에 매 반복마다 visit 배열 초기화.
            // 즉, 한 학생이 노트북을 찾는 과정에서 처리된 다른 학생이 다음 학생이 노트북을 찾는 과정에서 다시 처리될 수 있어야 함.
            visit = new boolean[N + 1];
            if(dfs(i)){
                result++;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}