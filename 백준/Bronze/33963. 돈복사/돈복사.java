import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int digit = n.length();

        int tempdigit = digit;
        int tempNum = Integer.parseInt(n);
        int count = 0;
        while(tempdigit <= digit){
            tempNum *= 2;
            tempdigit = String.valueOf(tempNum).length();
            count++;
        }

        System.out.println(count - 1);
    }
}