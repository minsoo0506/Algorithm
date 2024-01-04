import java.util.*;

class Main{
    public static int n;
    public static int[] arr;
    public static Integer [] dp;//null 값이 들어있는지 확인하기 위해 Integer형 사용
    public static int max;
    
    //top-down 방식 사용
    public static int sum(int index){//Integer는 wrapper 클래스이기 떄문에 int형으로 반환해도 상관없음.
        if(dp[index] == null){
            //배열 요소 이전까지의 합과 현재 배열과의 값을 비교해서 더 큰 값을 dp[index]에 할당
            dp[index] = Math.max(sum(index - 1) + arr[index], arr[index]);
            //dp[index]와 max값 비교하여 max값 최신화
            max = Math.max(max, dp[index]);
        }

        return dp[index];
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        scan.nextLine();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }
        dp = new Integer[n];
        
        //0번째의 값은 arr[0]의 값과 같음
        dp[0] = arr[0];
        //초기 max값은 arr[0]
        max = arr[0];

        sum(n - 1);//마지막 인덱스는 n-1

        System.out.println(max);
        scan.close();
    }
}