package programmers.부대복귀;

import java.util.*;

class Solution {
    private static int INF = 500_001;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] road : roads) {
            int s = road[0];
            int e = road[1];

            List<Integer> nexts = graph.getOrDefault(s, new ArrayList<Integer>());
            nexts.add(e);
            graph.put(s, nexts);

            nexts = graph.getOrDefault(e, new ArrayList<Integer>());
            nexts.add(s);
            graph.put(e, nexts);
        }

        int[] mem = new int[n + 1];
        Queue<int[]> queue = new LinkedList<int[]>();

        Arrays.fill(mem, INF);
        mem[destination] = 0;

        queue.add(new int[]{destination, 0});

        while(!queue.isEmpty()) {
            int[] item = queue.poll();
            int d = item[0];
            int cost = item[1];

            if (graph.containsKey(d)) {
                List<Integer> nexts = graph.get(d);

                nexts.stream().filter(nd -> mem[nd] > cost + 1)
                    .forEach(nd -> {
                        mem[nd] = cost + 1;
                        queue.add(new int[]{nd, cost + 1});
                    });
            }
        }


        return Arrays.stream(sources)
            .map(s -> mem[s] < INF ? mem[s] : -1)
            .toArray();
    }
}