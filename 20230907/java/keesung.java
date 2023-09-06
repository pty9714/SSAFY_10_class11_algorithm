import java.io.*;
import java.util.*;

class Solution {

    public static class Node {
        int r;
        int c;
        String value;

        Node parent;
        ArrayList<Node> children = new ArrayList<>();

        Node(int r, int c, String value) {
            this.r = r;
            this.c = c;
            this.value = value;
            this.parent = this;
        }
    }

    public static ArrayList<ArrayList<Node>> map = new ArrayList<ArrayList<Node>>(51);
    public static ArrayList<String> result = new ArrayList<>();

    public String[] solution(String[] commands) {

        for (int i = 0; i <= 50; i++) {
            map.add(new ArrayList<Node>(51));
            ArrayList<Node> arr = map.get(i);
            for (int j = 0; j <= 50; j++) {
                arr.add(new Node(i, j, ""));
            }
        }

        for (String command : commands) {
            String[] cmd = command.split(" ");
            switch (cmd[0]) {
                case "UPDATE":
                    if (cmd.length == 4) {
                        update(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]), cmd[3]);
                    } else {
                        update(cmd[1], cmd[2]);
                    }
                    break;
                case "MERGE":
                    merge(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]),
                            Integer.parseInt(cmd[4]));
                    break;
                case "UNMERGE":
                    unmerge(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    break;
                case "PRINT":
                    print(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    break;
            }

            // for (ArrayList<Node> arr : map) {
            // for (Node node : arr) {
            // System.out.print(node.value + " ");
            // }
            // System.out.println();
            // }
        }

        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void update(int r, int c, String value) {
        Node node = map.get(r).get(c).parent;
        node.value = value;
    }

    public static void update(String value1, String value2) {
        for (ArrayList<Node> arr : map) {
            for (Node node : arr) {
                if (node.value.equals(value1)) {
                    node.value = value2;
                }
            }
        }
    }

    public static void merge(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) {
            return;
        }
        Node node1 = map.get(r1).get(c1).parent;
        Node node2 = map.get(r2).get(c2).parent;
        if (node1 == node2) {
            return;
        }
        node2.parent = node1;
        node1.children.add(node2);
        for (Node node : node2.children) {
            node.parent = node1;
            node1.children.add(node);
        }
        node2.children.clear();
        if (node1.value != "") {
            node2.value = "";
        } else {
            node1.value = node2.value;
            node2.value = "";
        }
    }

    public static void unmerge(int r, int c) {
        Node node = map.get(r).get(c);
        Node parent = node.parent;
        if (node == parent) {
            for (Node child : node.children) {
                child.parent = child;
            }
            node.children.clear();
        } else {
            parent.children.remove(node);
            node.parent = node;
            node.value = parent.value;
            parent.value = "";

            for (Node child : parent.children) {
                child.parent = child;
            }
            parent.children.clear();
        }
    }

    public static void print(int r, int c) {
        Node node = map.get(r).get(c);
        if (node.parent.value.equals("")) {
            result.add("EMPTY");
        } else {
            result.add(node.parent.value);
        }
    }
}

// Union_Find 구조로 부모 처리함
// 부모가 있을 경우 부모에만 값을 저장함 (unmerge할때 value 교체 덜하기 위해)
// merge와 unmerge 처리 중요

// 테스트 1 〉 통과 (1.73ms, 72.1MB)
// 테스트 2 〉 통과 (1.13ms, 66.1MB)
// 테스트 3 〉 통과 (1.22ms, 72.8MB)
// 테스트 4 〉 통과 (1.23ms, 69.9MB)
// 테스트 5 〉 통과 (1.76ms, 76.6MB)
// 테스트 6 〉 통과 (1.36ms, 72.8MB)
// 테스트 7 〉 통과 (1.76ms, 73.8MB)
// 테스트 8 〉 통과 (2.82ms, 79MB)
// 테스트 9 〉 통과 (2.48ms, 79.7MB)
// 테스트 10 〉 통과 (2.48ms, 75.7MB)
// 테스트 11 〉 통과 (10.84ms, 73.5MB)
// 테스트 12 〉 통과 (7.89ms, 75.3MB)
// 테스트 13 〉 통과 (15.81ms, 80MB)
// 테스트 14 〉 통과 (11.16ms, 84.5MB)
// 테스트 15 〉 통과 (16.12ms, 80.5MB)
// 테스트 16 〉 통과 (12.73ms, 69.8MB)
// 테스트 17 〉 통과 (8.94ms, 68.3MB)
// 테스트 18 〉 통과 (11.14ms, 86.3MB)
// 테스트 19 〉 통과 (27.85ms, 78.8MB)
// 테스트 20 〉 통과 (4.70ms, 78.2MB)
// 테스트 21 〉 통과 (7.69ms, 78.4MB)
// 테스트 22 〉 통과 (17.91ms, 91.5MB)