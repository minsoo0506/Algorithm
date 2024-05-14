// 백준 1671 상어의 저녁식사 : 이분 매칭
import java.util.*;
import java.io.*;

// 상어의 대한 정보를 담는 클래스
class Shark {
    // 상어의 크기, 속도, 지능
    long size, speed, intellect;

    Shark(long size, long speed, long intellect) {
        this.size = size;
        this.speed = speed;
        this.intellect = intellect;
    }
}

public class Main {
    static int N; // 상어의 마리 수
    static Shark[] sharks; // 상어의 정보를 담는 배열
    static ArrayList<Integer>[] adj; // i번 상어가 먹을 수 있는 상어들의 번호를 담는 리스트 배열
    static int[] selected; // i번 상어를 먹는 상어의 번호를 담는 배열
    static boolean[] visited; // 방문 여부 체크

    public static boolean canEat(int a, int b){
        if(sharks[a].size == sharks[b].size && sharks[a].speed == sharks[b].speed && sharks[a].intellect == sharks[b].intellect){
            // 모든 상어의 능력치가 같을 때, 먹히고 먹는 상황 방지 
            return a > b; // 번호가 작은 상어가 번호가 큰 상어를 먹도록 한다.
        }

        // 상어 A의 크기, 속도, 지능이 상어 B의 크기, 속도, 지능보다 크거나 같다면 상어 A는 상어 B를 먹을 수 있다.
        if (sharks[a].size >= sharks[b].size && sharks[a].speed >= sharks[b].speed && sharks[a].intellect >= sharks[b].intellect) {
            return true;
        }

        return false;
    }

    public static boolean bipartiteMatch(int shark) {
        if (visited[shark]) return false;
        visited[shark] = true;

        for (int target : adj[shark]) {
            // target 번 상어를 먹을 수 있는 상어가 아직 없거나,
            // 있더라도 해당 상어가 다른 상어를 먹을 수 있는 경우
            if (selected[target] == -1 || bipartiteMatch(selected[target])) {
                selected[target] = shark;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sharks = new Shark[N];
        adj = new ArrayList[N];
        selected = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long size = Integer.parseInt(st.nextToken());
            long speed = Integer.parseInt(st.nextToken());
            long intellect = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(size, speed, intellect);
            adj[i] = new ArrayList<>();
        }

        // 그래프 형성
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                // 상어 i의 크기, 속도, 지능이 상어 j의 크기, 속도, 지능보다 크거나 같다면 상어 i는 상어 j를 먹을 수 있다.
                if (canEat(i, j)) {
                    adj[i].add(j);
                }
            }
        }

        // 매칭 관계를 -1로 초기화(자신을 먹을 수 있는 상어의 번호를 -1로 초기화)
        Arrays.fill(selected, -1);

        int match = 0;
        for (int shark = 0; shark < N; shark++) {
            // 한 상어가 최대 두 개의 상어를 먹을 수 있기 때문에 두번 실행
            if (bipartiteMatch(shark)) match++;
            Arrays.fill(visited, false);
            if (bipartiteMatch(shark)) match++;
            Arrays.fill(visited, false);
        }

        // 전체 상어 마리 수에서 먹힌 상어의 수를 빼기
        System.out.println(N - match);
    }
}