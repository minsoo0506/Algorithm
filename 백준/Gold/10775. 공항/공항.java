import java.io.*;

public class Main {
    private static int G, P;
    private static int[] parent;

    public static void makeParent(){
        for(int i = 1; i <= G; i++) parent[i] = i;
    }

    public static int find(int x){
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y) parent[x] = y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];

        makeParent();

        int count = 0;
        for(int i = 0; i < P; i++){
            int gate = Integer.parseInt(br.readLine());
            int emptyGate = find(gate);

            if(emptyGate == 0) break;

            count++;
            union(emptyGate, emptyGate - 1);
        }

        System.out.println(count);
    }
}