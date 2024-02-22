import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static int N;
    private static int[][] img;
    private static StringBuilder sb = new StringBuilder();

    public static boolean check(int x, int y, int size){
        int n = img[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(img[i][j] != n){
                    return false;
                }
            }
        }

        return true;
    }

    public static void resize(int x, int y, int size){
        if(check(x, y, size)){
            sb.append(img[x][y]);
            return;
        }

        sb.append("(");
        resize(x, y, size / 2);
        resize(x, y + size / 2, size / 2);
        resize(x + size / 2, y, size / 2);
        resize(x + size / 2, y + size / 2, size / 2);
        sb.append(")");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        img = new int[N][N];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                img[i][j] = line.charAt(j) - '0';
            }
        }

        resize(0, 0, N);

        System.out.println(sb);
    }
}