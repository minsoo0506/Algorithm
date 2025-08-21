import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] square;
    public static void makeSquare(int x1, int y1, int x2, int y2){
        for(int i = x1; i < x2; i++){
            for(int j = y1; j < y2; j++){
                square[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        square = new int[101][101];
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            makeSquare(x1, y1, x1 + 10, y1 + 10);
        }

        int area = 0;
        for(int i = 0; i <= 100; i++){
            for(int j = 0; j <= 100; j++){
                if(square[i][j] == 1){
                    area++;
                }
            }
        }

        bw.write(area + "");
        bw.flush();
        bw.close();
        br.close();
    }
}