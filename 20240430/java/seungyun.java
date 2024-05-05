import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.IOException;

public class B1972 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        String answer = "";
        while (!(str = br.readLine()).equals("*")){
            if(check(str)){
                answer = str + " is surprising.";
            } else{
                answer = str + " is NOT surprising.";
            }
            System.out.println(answer);
        }
    }

    private static boolean check(String str){
        int n = str.length();

        // 길이가 0, 1, 2, 3... n-2
        for(int i=0; i<n-1; i++){
            HashMap<String, Integer> hashMap = new HashMap<>();
            for(int j=0; j<n-1-i; j++){
                String s = str.charAt(j) + "" + str.charAt(j+i+1);
//                System.out.println(s);
                if(hashMap.containsKey(s)){
                    return false;
                }
                hashMap.put(s,1);
            }
        }
        return true;
    }

}
