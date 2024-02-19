import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] num, sequence;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int v, int depth){
        if(depth == M){
            for(int n : sequence){
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }
        else {
            for (int i = v; i < N; i++) {
                sequence[depth] = num[i];
                dfs(i, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        sequence = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(num);
        dfs(0,0);

        System.out.print(sb);
    }
}