import java.util.ArrayList;
class Solution {
    public static String[][] matrix;
    public static int[][] parents;
    public ArrayList<String> solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();
        matrix = new String[50][50];
        int r = 0, c = 0, parent = 0;
        make(); // 부모 배열 초기화
        for (String command : commands) {
            String[] s = command.split(" ");
            if(!s[0].equals("UPDATE") || s.length == 4) { // UPDATE value1 value2 아닌 경우 r, c와 r, c의 루트 노드 미리 조회
                r = Integer.parseInt(s[1]) - 1;
                c = Integer.parseInt(s[2]) - 1;
                parent = find(r, c);
            }
            switch(s[0]) {
                case "UPDATE" : 
                    if(s.length == 4) { // UPDATE r c value
                        matrix[parent / 50][parent % 50] = s[3]; // 루트 노드 update
                    }
                    else if(s.length == 3) { // UPDATE value1 value2
                        for(int i = 0; i < 50; i++) {
                            for(int j = 0; j < 50; j++) {
                                int p = find(i, j); // 부모 노드 찾기
                                if(matrix[p / 50][p % 50] != null && matrix[p / 50][p % 50].equals(s[1])) { // 루트 노드가 value1과 같으면
                                    matrix[p / 50][p % 50] = s[2]; // update
                                }
                            }
                        }
                    }
                    break;
                case "MERGE" : // MERGE r1 c1 r2 c2
                    union(r, c, Integer.parseInt(s[3]) - 1, Integer.parseInt(s[4]) - 1); // r2, c2를 r1, c1의 루트 노드로 MERGE
                    break;
                case "UNMERGE" : 
                    matrix[r][c] = matrix[parent / 50][parent % 50]; // 루트 노드의 값 r, c로 update
                    ArrayList<int[]> tempList = new ArrayList<>();
                    for(int i = 0; i < 50; i++) { 
                        for(int j = 0; j < 50; j++) {
                            if(find(i, j) == parent) { // 같은 루트 노드를 가진 노드들
                                if(i != r || j != c) { // r, c가 아니라면
                                    matrix[i][j] = null; // null 값으로 초기화
                                }
                                tempList.add(new int[] {i, j});
                            }
                        }
                    }
                    for(int[] index : tempList) {
                        parents[index[0]][index[1]] = index[0] * 50 + index[1];
                    }
                    break;
                case "PRINT" : 
                    String parentValue = matrix[parent / 50][parent % 50]; // r,c 의 루트 노드 값 출력
                    if(parentValue == null) parentValue = "EMPTY"; // 루트 노드 값이 null 이라면 EMPTY 
                    answer.add(parentValue);
                    break;
            }
        }
        return answer;
    }
    
    public static void make() {
        parents = new int[50][50];
        for(int i = 0; i < 50; i++) {
            for(int j = 0; j < 50; j++) {
                parents[i][j] = i * 50 + j;
            }
        } 
    }
    
    public static int find(int r, int c) {
        int parent = parents[r][c];
        if(parent == r * 50 + c) return parent;
        return parents[r][c] = find(parent / 50, parent % 50);
    }
    
    public static void union(int r1, int c1, int r2, int c2) {
        int root1 = find(r1, c1);
        int root2 = find(r2, c2);
        if(matrix[root1 / 50][root1 % 50] == null) {
            parents[root1 / 50][root1 % 50] = root2;
        }
        else {
            parents[root2 / 50][root2 % 50] = root1;
        }
    }
}
/*
테스트 1 〉	통과 (1.17ms, 72.2MB)
테스트 2 〉	통과 (0.75ms, 73.1MB)
테스트 3 〉	통과 (0.32ms, 75.3MB)
테스트 4 〉	통과 (0.42ms, 69.7MB)
테스트 5 〉	통과 (0.95ms, 84MB)
테스트 6 〉	통과 (0.85ms, 74.3MB)
테스트 7 〉	통과 (2.11ms, 87.6MB)
테스트 8 〉	통과 (0.98ms, 75.2MB)
테스트 9 〉	통과 (2.76ms, 81.8MB)
테스트 10 〉	통과 (2.52ms, 76.6MB)
테스트 11 〉	통과 (5.06ms, 71.4MB)
테스트 12 〉	통과 (7.94ms, 75.6MB)
테스트 13 〉	통과 (18.75ms, 77MB)
테스트 14 〉	통과 (19.62ms, 79.3MB)
테스트 15 〉	통과 (19.18ms, 97.3MB)
테스트 16 〉	통과 (11.11ms, 85.5MB)
테스트 17 〉	통과 (17.07ms, 88.9MB)
테스트 18 〉	통과 (13.56ms, 85.9MB)
테스트 19 〉	통과 (46.02ms, 74.5MB)
테스트 20 〉	통과 (3.90ms, 66.3MB)
테스트 21 〉	통과 (7.93ms, 77.8MB)
테스트 22 〉	통과 (11.61ms, 80MB)
*/