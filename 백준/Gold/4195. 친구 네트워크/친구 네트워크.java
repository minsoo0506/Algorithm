// 백준 4195 : 분리 집합 문제
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static int F;
    private static Map<String, String> parent; // Key : 자식, Value : 부모
    private static Map<String, Integer> size; // Key : 루트 노드, Value : 집합의 크기

    // 새로운 원소를 집합에 추가하는 메소드
    public static void makeSet(String s) {
        parent.put(s, s); // 자신을 부모로 설정
        size.put(s, 1); // 초기 크기는 1
    }

    // 주어진 원소의 루트를 찾는 메소드
    public static String find(String s){
        if(!parent.get(s).equals(s)){ // 부모가 자신이 아니라면 루트가 아님
            parent.put(s, find(parent.get(s))); // 부모의 루트를 찾아서 설정
        }
        return parent.get(s); // 루트 반환
    }

    // 두 집합을 합치는 메소드
    public static void union(String a, String b){
        String parentA = find(a); // a의 루트 찾기
        String parentB = find(b); // b의 루트 찾기
        // 서로 다른 집합일 경우(루트가 다르다면)
        if(!parentA.equals(parentB)){
            // 두 집합 합치기
            parent.put(parentA, parentB); // a의 루트를 b의 루트로 설정
            // 새로운 집합의 크기 업데이트
            size.put(parentB, size.get(parentA) + size.get(parentB));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            F = Integer.parseInt(br.readLine());
            parent = new HashMap<>();
            size = new HashMap<>();

            for(int j = 0; j < F; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String friendA = st.nextToken();
                String friendB = st.nextToken();

                if(!parent.containsKey(friendA)) makeSet(friendA);
                if(!parent.containsKey(friendB)) makeSet(friendB);

                union(friendA, friendB); // a와 b를 같은 집합으로 합치기
                sb.append(size.get(find(friendA))).append("\n"); // a가 속한 집합의 크기 출력
            }
        }

        System.out.println(sb);
    }
}