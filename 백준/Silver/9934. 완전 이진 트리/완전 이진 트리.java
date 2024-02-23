import java.util.*;
import java.io.*;

public class Main {
    static int K, N;
    static int[] inOrder;
    static ArrayList<Integer>[] tree;

    static void treeSearch(int start, int end, int depth) {
        int mid = (start + end) / 2;
        tree[depth].add(inOrder[mid]);

        if(depth == K) return;

        treeSearch(start, mid - 1, depth + 1);
        treeSearch(mid + 1, end, depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        N = (int) Math.pow(2, K) - 1;
        tree = new ArrayList[K + 1];
        inOrder = new int[N + 1];

        for(int i = 0; i <= K; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        treeSearch(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= K; i++){
            for(int node : tree[i]){
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}