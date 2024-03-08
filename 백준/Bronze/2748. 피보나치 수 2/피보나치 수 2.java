import java.io.*;

public class Main {
    public static long fibo(int n){
        if(n <= 1) return 1;
        if(n == 2) return 1;

        long f1 = 1;
        long f2 = 1;
        for(int i = 3; i <= n; i++){
            long temp = f1;
            f1 = f2;
            f2 += temp;
        }

        return f2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibo(n));
    }
}