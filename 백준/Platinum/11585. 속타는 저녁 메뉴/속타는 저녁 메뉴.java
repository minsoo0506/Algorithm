import java.io.*;

public class Main {
    public static int[] failure;
    public static int n;
    public static char[] pattern;
    public static char[] target;

    // kmp 알고리즘 사용하여 count하는 메소드
    public static int kmp() {
        int i = 0, j = 0; // i는 target 인덱스, j는 pattern 인덱스
        int lent = target.length;
        int lenp = pattern.length;
        int count = 0;

        while(i < lent) {
            if(target[i] == pattern[j]) {
                i++;
                j++;
                if(j == lenp) { // 매칭 완료
                    if(i - j < n) count++; // 첫번째 N칸 내에서만 카운트
                    j = failure[j - 1];   // 다음 위치로 점프
                }
            }
            else if(j == 0) {
                i++;
            }
            else {
                j = failure[j - 1];
            }
        }

        return count;
    }

    // 실패 함수를 생성하는 메소드
    public static void makeFailure() {
        int j = 0;
        for(int i = 1; i < pattern.length; i++) {
            while(j > 0 && pattern[i] != pattern[j]) {
                j = failure[j - 1];
            }
            if(pattern[i] == pattern[j]) {
                failure[i] = ++j;
            }
        }
    }

    // 기약분수 계산을 위해 gcd를 계산하는 메소드
    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String[] patternStr = br.readLine().split(" ");
        String[] targetStr = br.readLine().split(" ");

        pattern = new char[n];
        target = new char[2 * n - 1];

        for(int i = 0; i < n; i++) {
            pattern[i] = patternStr[i].charAt(0);
            target[i] = targetStr[i].charAt(0);
            if(i < n - 1) { // 마지막 문자는 추가하지 않음
                target[i + n] = targetStr[i].charAt(0);
            }
        }

        failure = new int[n];
        makeFailure();

        int matchCount = kmp();

        int g = gcd(matchCount, n);
        String result = (matchCount / g) + "/" + (n / g);
        if(matchCount == n) result = "1/1";

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}