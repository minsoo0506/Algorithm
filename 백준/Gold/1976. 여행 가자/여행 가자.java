import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] parent;

    public static void makeParent(){
        for(int i = 0; i < N; i++) parent[i] = i;
    }

    public static int find(int x){
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x < y) {
            parent[y] = x;
        }
        else {
            parent[x] = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N];
        makeParent();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int isConnected = Integer.parseInt(st.nextToken());
                if(isConnected == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int parentNum;
        int prev = 0;
        for(int i = 0; i < M; i++){
            int city = Integer.parseInt(st.nextToken()) - 1;
            parentNum = find(city);

            if(i == 0) {
                prev = parentNum;
                continue;
            }
            else {
                if(prev != parentNum) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }
}