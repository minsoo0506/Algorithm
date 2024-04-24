import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        double A = Double.parseDouble(br.readLine());
        double B = Double.parseDouble(br.readLine());
        double C = Double.parseDouble(br.readLine());
        double D = Double.parseDouble(br.readLine());

        int korean = (int) Math.ceil(A / C);
        int math = (int) Math.ceil(B / D);

        System.out.println(L - Math.max(korean, math));
    }
}