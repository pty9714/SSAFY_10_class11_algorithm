package stock.chart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][][][] game = new int[6][1024][N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                game[0][0][i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int repeat = 1; repeat < 6; repeat++) {
            int count = (int) Math.pow(4, repeat);
            int before = count / 4;
            for (int i = 0; i < before; i++) {
                count--;
                game[repeat][count] = goLeft(game[repeat - 1][i]);
                count--;
                game[repeat][count] = goRight(game[repeat - 1][i]);
                count--;
                game[repeat][count] = goUp(game[repeat - 1][i]);
                count--;
                game[repeat][count] = goDown(game[repeat - 1][i]);
            }
        }

        int max = 0;
        for (int i = 0; i < 1024; i++) {
            max = Math.max(max, getMax(game[5][i]));
        }
        System.out.println(max);
    }

    private static int getMax(int[][] graph) {
        int max = 0;
        for (int[] ints : graph) {
            for (int anInt : ints) {
                max = Math.max(max, anInt);
            }
        }
        return max;
    }

    private static int[][] goDown(int[][] graph) {
        int[][] result = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            int[] temp = new int[graph.length];
            int index = 0;
            for (int j = graph.length - 1; j >= 0; j--) {
                if (graph[j][i] != 0) {
                    temp[index] = graph[j][i];
                    index++;
                }
            }
            for (int j = 0; j < temp.length - 1; j++) {
                if (temp[j] == temp[j + 1]) {
                    temp[j] *= 2;
                    temp[j + 1] = 0;
                }
            }
            index = 0;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] != 0) {
                    result[index][i] = temp[j];
                    index++;
                }
            }
        }
        return result;
    }

    private static int[][] goUp(int[][] graph) {
        int[][] result = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            int[] temp = new int[graph.length];
            int index = 0;
            for (int j = 0; j < graph.length; j++) {
                if (graph[j][i] != 0) {
                    temp[index] = graph[j][i];
                    index++;
                }
            }
            for (int j = 0; j < temp.length - 1; j++) {
                if (temp[j] == temp[j + 1]) {
                    temp[j] *= 2;
                    temp[j + 1] = 0;
                }
            }
            index = 0;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] != 0) {
                    result[index][i] = temp[j];
                    index++;
                }
            }
        }
        return result;
    }

    private static int[][] goRight(int[][] graph) {
        int[][] result = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            int[] temp = new int[graph.length];
            int index = 0;
            for (int j = graph.length - 1; j >= 0; j--) {
                if (graph[i][j] != 0) {
                    temp[index] = graph[i][j];
                    index++;
                }
            }
            for (int j = 0; j < temp.length - 1; j++) {
                if (temp[j] == temp[j + 1]) {
                    temp[j] *= 2;
                    temp[j + 1] = 0;
                }
            }
            index = 0;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] != 0) {
                    result[i][index] = temp[j];
                    index++;
                }
            }
        }
        return result;
    }

    private static int[][] goLeft(int[][] graph) {
        int[][] result = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            int[] temp = new int[graph.length];
            int index = 0;
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] != 0) {
                    temp[index] = graph[i][j];
                    index++;
                }
            }
            for (int j = 0; j < temp.length - 1; j++) {
                if (temp[j] == temp[j + 1]) {
                    temp[j] *= 2;
                    temp[j + 1] = 0;
                }
            }
            index = 0;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] != 0) {
                    result[i][index] = temp[j];
                    index++;
                }
            }
        }
        return result;

    }
}