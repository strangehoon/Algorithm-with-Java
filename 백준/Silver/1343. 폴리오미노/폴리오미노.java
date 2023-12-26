import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.replace("XXXX", "AAAA");
        str = str.replace("XX", "BB");
        boolean flag = true;
        for(char ch : str.toCharArray()){
            if(ch =='X'){
                flag = false;
                bw.write(String.valueOf(-1));
                break;
            }
        }
        if(flag==true){
            bw.write(String.valueOf(str));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
