// 백준 9576 책 나눠주기
// 이분 매칭 : dfs(재귀)로 풀이
import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] matchedStudent;
    private static boolean[] visit;
    private static ArrayList<Integer>[] graph;
    private static int result;

    public static boolean dfs(int studentNum){
        if(visit[studentNum]) return false;
        else visit[studentNum] = true;

        for(int book : graph[studentNum]){
            if(matchedStudent[book] == -1 || dfs(matchedStudent[book])){
                matchedStudent[book] = studentNum;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            matchedStudent = new int[N + 1];
            graph = new ArrayList[M + 1];

            Arrays.fill(matchedStudent, -1);

            for(int j = 0; j <= M; j++){
                graph[j] = new ArrayList<>();
            }

            for(int j = 1; j <= M; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                for(int k = a; k <= b; k++){
                    graph[j].add(k);
                }
            }

            result = 0;
            for(int j = 1; j <= M; j++){
                visit = new boolean[M + 1];
                if(dfs(j)){
                    result++;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}