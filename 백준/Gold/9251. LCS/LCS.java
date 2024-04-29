// 백준 9251 LCS : DP로 풀이
// LCS : 최장 공통 부분 수열(Longest Common Subsequence)
// 주어진 여러 개의 수열(문제열) 모두의 부분수열이 되는 수열들 중에 가장 긴 것을 찾는 문제
// -> 꼭 연속된 문자열이 아니어도 괜찮음(Longest Common Substring 이 아니기 때문)
import java.io.*;

public class Main {
    // LCS의 길이를 구하는 메소드
    public static int getLcsLength(String str1, String str2){
        int n = str1.length(); // str1의 길이
        int m = str2.length(); // str2의 길이
        int[][] LCS = new int[n + 1][m + 1];

        // 마진 설정
        for(int i = 0; i <= n; i++) LCS[i][0] = 0;
        for(int i = 0; i <= m; i++) LCS[0][i] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    // 두 문자가 같은 상황이 오면 지금까지의 최대 공통 부분수열에 1을 더해주기
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    // 현재의 문자를 비교하는 과정 이전의 최대 공통 부분수열은 계속해서 유지되기 때문
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }

        return LCS[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(getLcsLength(str1, str2));
    }
}
