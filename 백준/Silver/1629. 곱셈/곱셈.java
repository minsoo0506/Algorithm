import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static long C;

    public static long pow(long a, long b){

        if(b == 1) {
            return a % C;
        }

        long temp = pow(a, b / 2);

        if(b % 2 == 1) {
            return (temp * temp % C) * a % C;
        }

        return temp * temp % C;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bw.write(pow(A, B) + "");

        bw.flush();
        bw.close();
        br.close();
    }
}