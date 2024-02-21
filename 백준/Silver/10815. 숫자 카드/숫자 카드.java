import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] card;
    private static int[] num;
    public static boolean binarySearch(int n){
        int start = 0;
        int end = N - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(card[mid] < n){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (start >= N) return false;
        return card[start] == n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        M = Integer.parseInt(br.readLine());
        num = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            if(binarySearch(num[i])){
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}