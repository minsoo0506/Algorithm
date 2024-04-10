import java.io.*;
import java.util.*;
 
public class Main {
    static int N;
    static int K; 
    static int A[];
    
    public static boolean possible(long target) {
        int cnt = 0;
 
        for (int i = 0; i < N; i++) {
            cnt += A[i] / target;
        }
 
        return cnt >= K;
    }
    
    static void binarySearch() {
        long s = 0, e = Integer.MAX_VALUE, rel = 0;
 
        while (s <= e) {
            long mid = (s + e) / 2;
 
            if (possible(mid)) {
                rel = mid;
                s = mid + 1;
            }
            else e = mid - 1;
        }
 
        System.out.println(rel);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
 
        A = new int[N];
 
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(br.readLine());
 
        binarySearch();
    }
}