import java.util.ArrayList;


class Solution {

        public int[] solution(String s) {
            int[] answer = {};
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length() - 1; i++) {
                char c = s.charAt(i);
                if (c == '{') {
                    temp = new ArrayList<>();
                } else if (c == '}') {
                    temp.add(Integer.parseInt(sb.toString()));
                    list.add(temp);
                    sb = new StringBuilder();
                } else if (c == ',') {
                    if (s.charAt(i - 1) != '}') {
                        temp.add(Integer.parseInt(sb.toString()));
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(c);
                }
            }

            list.sort((o1, o2) -> o1.size() - o2.size());

            answer = new int[list.size()];

            for (int i = 0; i < list.size(); i++) {
                ArrayList<Integer> curr = list.get(i);
                label:
                for (int j = 0; j < curr.size(); j++) {
                    int num = curr.get(j);
                    for (int k = 0; k < i; k++) {
                        if (answer[k] == num) continue label;
                    }
                    answer[i] = num;
                    break;
                }
            }

            return answer;
        }

    }
