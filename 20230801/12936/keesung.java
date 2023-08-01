import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class keesung {
        public int[] solution(int n, long k) {
            int[] answer = new int[n];
//            List list = new ArrayList<Integer>();
            List list = new ArrayList<Integer>();
            for (int i = 1; i <= n; i ++){
                list.add(i);
            };

            long[] products = new long[n];
            // 몫 만큼 의 인덱스를 넣고 그 다음을 또 나눠서 몫만큼 넣는다.
            products[0] = 0;
            products[1] = 1;
            for (int i = 2; i < n; i++) {
                products[i] = products[i-1] * (i);
            }

            for (int i = 0; i < n-1; i++) {

                System.out.println(products[n-1-i]);
                long tmpNum = k / products[n-1-i];
                System.out.println(k + " --- " + tmpNum);
                k -= tmpNum * products[n-1-i];
//                if (k == 0) {
//                    tmpNum -= 1
//                    for (int j = i; j < n; j++) {
//                        answer[j] = (int) list.get(list.size()-1);
//                        list.remove(list.get(list.size()-1));
//                    }
//                    break;
//
//                } else {
//                    int tmp = (int) list.get((int)tmpNum);
////                    System.out.println((int)tmpNum);
////                    System.out.println(tmp);
//                    answer[i] = tmp;
//                    list.remove((int)tmpNum);
//                }
                if (k == 0) {
                    tmpNum -= 1;

                }
                int tmp = (int) list.get((int)tmpNum);
//                    System.out.println((int)tmpNum);
//                    System.out.println(tmp);
                answer[i] = tmp;
                list.remove((int)tmpNum);
            }

            answer[n-1] = (int) list.get(0);
            return answer;
        }
    }
