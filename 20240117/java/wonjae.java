import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Point> jewelry = new PriorityQueue<>((p1, p2)->{
            if(p1.y == p2.y) return p1.x - p2.x;
            return p2.y - p1.y;
        });

        ArrayList<Integer> bag= new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            jewelry.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for(int i = 0; i < k; i++){
            bag.add(Integer.parseInt(br.readLine()));
        }

        bag.sort((b1, b2)-> b1 - b2);

        long answer = 0;

        int curr_bag;
        Point curr_jewelry;

        while(!jewelry.isEmpty()){
            curr_jewelry = jewelry.poll();
            if(bag.isEmpty()) break;
            for(int i = 0; i < bag.size(); i++){
                curr_bag = bag.get(i);
                if(curr_bag >= curr_jewelry.x){
                    answer += curr_jewelry.y;
                    bag.remove(i);
                    break;
                }
            }

        }
        System.out.println(answer);
    }
}

//아 몰라
