import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int N, int number) {
        ArrayList<Integer>[] D = new ArrayList[8];
        for(int i=0; i<8; i++) {
            D[i] = new ArrayList<Integer>();
        }
        D[0].add(N);
        for(int i=0; i<7; i++) {
            for(Integer x : D[i]) {
                if(x==number) return i;
                D[i+1].add(x+N);
                if(x-N>0 && x-N!=N) D[i+1].add(x-N);
                if(x*N!=N) D[i+1].add(x*N);
                if(Math.floor(x/N)>0 && Math.floor(x/N)!=N) D[i+1].add((int)Math.floor(x/N));
            }
        }
        if(D[7].contains(number)) return 8;
        return -1;
    }
}
