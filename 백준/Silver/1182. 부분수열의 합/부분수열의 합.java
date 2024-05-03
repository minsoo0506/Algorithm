import java.io.*;
import java.util.*;

public class Main {
    private static int N, S;
    private static int[] arr;
    private static int count;

    public static void dfs(int depth, int sum){
        if(depth == N){
            return;
        }
        if(sum + arr[depth] == S){
            count++;
        }
        dfs(depth + 1, sum + arr[depth]); 
        dfs(depth + 1, sum); 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        dfs(0, 0);

        System.out.println(count);
    }
}