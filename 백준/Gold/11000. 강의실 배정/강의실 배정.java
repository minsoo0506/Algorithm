import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 강의에 대한 정보를 담는 클래스
class Lecture implements Comparable<Lecture> {
    int start; // 강의 시작 시간
    int end; // 강의 종료 시간

    public Lecture(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture o) {
        // 시작 시간이 같으면 종료 시간으로 비교
        if (this.start == o.start) {
            return this.end - o.end;
        } else {
            //  시작 시간이 다르면 시작 시간으로 비교
            return this.start - o.start;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> lectures = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures.offer(new Lecture(start, end));
        }

        // 현재 사용 중인 강의실의 강의 종료 시간을 저장하는 우선순위 큐(큐의 사이즈가 곧 강의실의 개수)
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        while(!lectures.isEmpty()){
            Lecture lecture = lectures.poll();
            /*
            endTimes 큐가 비어 있지 않고, endTimes 큐의 맨 앞에 있는 강의 종료 시간이 현재 강의의 시작 시간보다 이전이라면,
            같은 강의실을 사용해도 되므로 endTimes 큐에서 제거
            */
            if(!endTimes.isEmpty() && endTimes.peek() <= lecture.start){
                endTimes.poll();
            }

            /*
            현재 강의의 종료 시간을 endTimes 큐에 추가.
            (현재 강의를 수강하기 위해 새로운 강의실을 사용하거나,
            기존의 강의실에서 강의를 이어서 수강한다는 것을 의미)
            */
            endTimes.offer(lecture.end);
        }

        System.out.println(endTimes.size());
    }
}