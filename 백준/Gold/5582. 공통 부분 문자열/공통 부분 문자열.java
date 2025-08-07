/* (완전 탐색) 시간 초과
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        int result = 0;

        for(int i = 0; i < s1.length; i++){
            for(int j = 0; j < s2.length; j++){
                if(s1[i] == s2[j]){
                    int index1 = i;
                    int index2 = j;
                    int count = 0;
                    while(index1 < s1.length && index2 < s2.length && s1[index1++] == s2[index2++]){
                        count++;
                    }
                    result = Math.max(result, count);
                }
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
*/

// DP (Longest Common Substring)
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int lcsLength = 0;
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    lcsLength = Math.max(lcsLength, dp[i][j]);
                }
            }
        }

        bw.write(lcsLength + "");
        bw.flush();
        bw.close();
        br.close();
    }
}