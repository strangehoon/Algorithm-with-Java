import java.io.*;
import java.util.*;

public class Main {

    public static class Nation {

        int num;
        int gold;
        int silver;
        int bronze;

        public Nation(int num, int gold, int silver, int bronze){
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        ArrayList<Nation> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st2.nextToken());
            int gold = Integer.parseInt(st2.nextToken());
            int silver = Integer.parseInt(st2.nextToken());
            int bronze = Integer.parseInt(st2.nextToken());
            arrayList.add(new Nation(num, gold, silver, bronze));
        }
        Collections.sort(arrayList, new Comparator<Nation>(){
            @Override
            public int compare(Nation o1, Nation o2) {
                if(o1.gold==o2.gold){
                    if(o1.silver==o2.silver){
                        return o1.bronze-o2.bronze;
                    }
                    else{
                        return o1.silver-o2.silver;
                    }
                }
                else{
                    return o1.gold-o2.gold;
                }
            }
        });
        int rank = 1;
        if(arrayList.get(0).num==k)
            bf.write(String.valueOf(rank));
        for(int i=1; i<n; i++){
            if((arrayList.get(i-1).gold!=arrayList.get(i).gold)||
                    (arrayList.get(i-1).silver!=arrayList.get(i).silver) ||
                    (arrayList.get(i-1).bronze!=arrayList.get(i).bronze)){
                rank ++;
            }
            if(arrayList.get(i).num==k){
                bf.write(String.valueOf(rank));
                break;
            }
        }
        bf.flush();
        bf.close();
        br.close();
    }
}