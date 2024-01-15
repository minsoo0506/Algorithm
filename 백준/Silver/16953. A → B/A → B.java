import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long A = scan.nextLong();
        long B = scan.nextLong();

        int count = 1;
        while (B != A) {
            if (B < A) {
                count = -1;
                break;
            }

            String str = String.valueOf(B);
            // 맨 끝자리가 1이거나 B가 2로 나누어 떨어지지 않는다면, A로 만들 수 없다.
            if (str.charAt(str.length() - 1) != '1' && B % 2 != 0) {
                count = -1;
                break;
            }

            if (B % 2 == 0) { // B가 2로 나누어 떨어진다면, 2로 나눈다.
                B /= 2;
            } else { // 그렇지 않고, 맨 끝자리가 1이라면 1을 없앤다.
                str = str.substring(0, str.length() - 1);
                B = Long.parseLong(str);
            }

            count++; // 횟수 증가.
        }
        System.out.println(count);
    }
}