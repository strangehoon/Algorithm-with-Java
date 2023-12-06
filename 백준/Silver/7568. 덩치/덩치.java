import java.io.*;
import java.util.*;

public class Main {

    public static class Person{
        int weight;
        int height;

        public Person(int weight, int height){
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            Person person = new Person(weight, height);
            people[i]=person;
        }
        int[] rank = new int[N];
        for(int i=0; i<N; i++){
            rank[i] = 1;
        }
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if((people[i].height>people[j].height)&&(people[i].weight>people[j].weight)){
                    rank[j]+=1;
                } else if ((people[i].height<people[j].height)&&(people[i].weight<people[j].weight)) {
                    rank[i]+=1;
                }
            }
        }
        for(int x:rank)
            bf.write(String.valueOf(x +" "));
        bf.flush();
        bf.close();
        br.close();
    }
}