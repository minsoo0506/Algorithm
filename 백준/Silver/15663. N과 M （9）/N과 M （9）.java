import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static int N, M;
    public static int[] num, sequence;
    public static boolean[] visit;
    public static LinkedHashSet<String> set;

    public static void dfs(int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int n : sequence){
                sb.append(n).append(" ");
            }
            set.add(sb.toString());
        }
        else {
            for (int i = 0; i < N; i++) {
                if(visit[i]) continue;

                visit[i] = true;
                sequence[depth] = num[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        visit = new boolean[N];
        sequence = new int[M];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(num);
        dfs(0);

        set.forEach(System.out::println);
    }
}