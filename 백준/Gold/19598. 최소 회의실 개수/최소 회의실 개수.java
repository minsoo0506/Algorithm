import java.io.*;
import java.util.*;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        // 시작 시간을 기준으로 오름차순 정렬
        if (this.start == o.start) return this.end - o.end;
        else return this.start - o.start;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 종료시간을 저장하는 우선순위 큐
        for (Meeting meeting : meetings){
            if(!pq.isEmpty() && pq.peek() <= meeting.start){
                pq.poll();
            }
            pq.offer(meeting.end);
        }

        bw.write(pq.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}