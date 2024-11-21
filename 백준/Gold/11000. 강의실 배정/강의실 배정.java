import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    // 17:10

//                1) 기본 배열 start를 기준으로 오름차순
//                2) 우선순위 큐 end를 기준으로 오름차순
//    1 8           18 27 411
//    2 7
//    4 6
//    6 11
//    9 10

    public static class Course {
        int start;
        int end;

        public Course(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        Course[] arr = new Course[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            arr[i] = new Course(start, end);
        }

        Arrays.sort(arr, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                if(o1.start==o2.start)
                    return o1.end-o2.end;
                else
                    return o1.start-o2.start;
            }
        });

        PriorityQueue<Course> pq = new PriorityQueue<>(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.end-o2.end;
            }
        });

        for(int i=0; i<N; i++){
            Course course = arr[i];
            if(pq.isEmpty()){
                pq.offer(course);
            }
            else{
                Course pCourse = pq.poll();
                if(course.start<pCourse.end){
                    pq.offer(course);
                    pq.offer(pCourse);
                }
                else{
                    pq.offer(new Course(pCourse.start, course.end));
                }
            }
        }

        bw.write(String.valueOf(pq.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}
