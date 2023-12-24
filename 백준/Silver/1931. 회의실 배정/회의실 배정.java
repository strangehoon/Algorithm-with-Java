import java.io.*;
import java.util.*;

public class Main {
    static class Meeting{
        int start_time;
        int end_time;

        public Meeting(int start_time, int end_time){
            this.start_time = start_time;
            this.end_time = end_time;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_time = Integer.parseInt(st.nextToken());
            int end_time = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start_time, end_time);
        }

        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end_time==o2.end_time){
                    return o1.start_time - o2.start_time;
                }
                else
                    return o1.end_time - o2.end_time;
            }
        });
        int cnt = 1;
        int flag = meetings[0].end_time;
        for(int i=1; i<N; i++){
            if(flag<=meetings[i].start_time){
                flag = meetings[i].end_time;
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
