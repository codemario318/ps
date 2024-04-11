package programmers.합승_택시_요금;

import java.util.*;

class Solution {
    private static final int INF = 200_000_001;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        int[][] graph = getGraph(n, fares);

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int cost = graph[i][k] + graph[k][j];

                    if (graph[i][j] > cost) {
                        graph[i][j] = cost;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i == s) {
                continue;
            }

            answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }

        return Math.min(
            answer,
            graph[s][a] + graph[s][b]
        );
    }

    private int[][] getGraph(int n, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int[] fare : fares) {
            int s = fare[0];
            int e = fare[1];
            int c = fare[2];

            graph[s][e] = c;
            graph[e][s] = c;
        }

        return graph;
    }
}
