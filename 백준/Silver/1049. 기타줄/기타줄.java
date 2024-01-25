import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][2];

        int lowPricePakage = 1000;
        int lowPriceEach = 1000;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            if(lowPricePakage > arr[i][0]){
                lowPricePakage = arr[i][0];
            }
            if(lowPriceEach > arr[i][1]){
                lowPriceEach = arr[i][1];
            }
        }

        int resultPrice = 0;
        resultPrice += (N / 6) * Math.min(lowPricePakage, lowPriceEach * 6);
        N %= 6;
        resultPrice += Math.min(lowPricePakage, lowPriceEach * N);

        System.out.println(resultPrice);
    }
}