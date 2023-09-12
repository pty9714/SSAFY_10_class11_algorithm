import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static HashMap<Integer, int[]> specialMap = new HashMap<>();

//    public static HashSet<HashSet<Node>> visited = new HashSet<>();
    public static ArrayList<Node> normalNodes = new ArrayList<>(41);
    public static ArrayList<Node> specialNodes = new ArrayList<>(41);
    public static int[] dices = new int[10];
    public static int score = 0;
    public static int result = 0;
//    public static ArrayList<Node> allivedNodes = new ArrayList<>(5);
    public static int arriveCount = 0;
    public static void main(String[] args) throws IOException {

        specialMap.put(10, new int[] {13, 16, 19, 25, 30, 35, 40});
        specialMap.put(20, new int[] {22, 24, 25, 30, 35, 40});
        specialMap.put(30, new int[] {28, 27, 26, 25, 30, 35, 40});

//        for (int i = 0; i < 5; i++) {
//            allivedNodes.add(new Node(0));
//        }


        for (int i = 0; i < 41; i++) {
            normalNodes.add(new Node(i));
            specialNodes.add(new Node(i));
        }
//        normalNodes.get(41).value = 0;
//        specialNodes.get(41).value = 0;

        for (int special = 30; special >= 10; special -= 10) {
            for (Integer num : specialMap.get(special)) {
                specialNodes.get(num).specialCheck = special;
            }
        }
        specialNodes.set(40, normalNodes.get(40));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < 10; i++) {
            dices[i] = Integer.parseInt(input[i]);
        }

        HashSet<Node> horses = new HashSet<>();

        dfs(0, horses);
        System.out.println(result);
    }
    public static Node getNextNode(Node node, int dice) {
        if (node.specialCheck != 0) {
            int[] special = specialMap.get(node.specialCheck);
            for (int i = 0; i < special.length; i++) {
                if (special[i] == node.value) {
                    if (i + dice >= special.length) {
                        return null;
                    }
                    return specialNodes.get(special[i + dice]);
                }
            }
        } else if (node.value == 10 || node.value == 20 || node.value == 30) {
            int[] special = specialMap.get(node.value);
            if (dice >= special.length) {
                return null;
            }
            return specialNodes.get(special[dice-1]);
        }
        if (node.value + dice * 2 >= 41) {
            return null;
        }
        return normalNodes.get(node.value + dice * 2);


    }
    public static void dfs(int index, HashSet<Node> horses) {
//        System.out.println(horses.toString() + score);
//        if (score == 218) {
//            System.out.println("here");
//        }
        if (index == 10 || arriveCount == 4) {
            result = Math.max(result, score);
            return;
        }

        for (Node node : horses) {
            Node nextNode = getNextNode(node, dices[index]);
            if (horses.contains(nextNode)) {
                continue;
            }
            HashSet<Node> newHorses = new HashSet<>(horses);
            newHorses.remove(node);
            if (nextNode == null) {
                arriveCount++;
                dfs(index + 1, newHorses);
                arriveCount--;
            } else {
                newHorses.add(nextNode);
                score += nextNode.value;
                dfs(index + 1, newHorses);
                score -= nextNode.value;
            }

        }
        if (horses.size() < 4 - arriveCount) {
            HashSet<Node> newHorses = new HashSet<>(horses);
            Node nextNode = normalNodes.get(dices[index] * 2);
            if (horses.contains(nextNode)) {
                return;
            }
            newHorses.add(nextNode);
            score += nextNode.value;
            dfs(index + 1, newHorses);
            score -= nextNode.value;
        }
    }
    public static class Node implements Comparable<Node>{

        int specialCheck = 0;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public int compareTo(Node other) {
            if (this.value == other.value) {
                return this.specialCheck - other.specialCheck;
            }
            return this.value - other.value;
        }

//        @Override
//        public int hashCode() {
//            return specialCheck * 10 + value;
//        }
       public String toString() {
            return specialCheck + " " + value;
       }
    }
}

// 23704 메모리	184ms
// 구현
// Node를 어떻게 처리할 지가 관건
// 40번 노드는 공통 노드로 사용, 10 20 30에서 꺽는 곳은 일반노드 아닌 곳은 특수 노드로 사용
// 16, 22, 24, 26, 28, 30 등 공통 숫자 생각해야함