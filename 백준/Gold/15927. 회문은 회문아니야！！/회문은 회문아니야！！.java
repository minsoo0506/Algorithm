// 백준 15927 에드 훅 - 펠린드롬 문제
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    // 펠린드롬 문자열인지 판별하는 메소드
    public static boolean isPalindrome(String str){
        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        
        // 전체 문자열이 펠린드롬인지 판별
        if(isPalindrome(str)){
            // 처음부터 끝까지 같은 문자열인지 판별
            boolean allSame = true;
            for(int i = 1; i < str.length(); i++){
                if(str.charAt(i) != str.charAt(0)){
                    allSame = false;
                    break;
                }
            }
            // 처음부터 끝까지 같은 문자열이라면 -1 출력
            if(allSame){
                System.out.println(-1);
            } else {
                // 전체 문자열이 펠린드롬이라면 전체 문자열 길이에서 -1을 한 값 출력
                System.out.println(str.length() - 1);
            }
        } else {
            // 전체 문자열이 펠린드롬이 아니라면 문자열 길이 그대로 출력
            System.out.println(str.length());
        }
    }
}