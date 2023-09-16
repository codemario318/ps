package programmers.피로드;
class Solution {
    int[][] board;
    int max;

    public int solution(int k, int[][] dungeons) {
        this.board = dungeons;
        boolean[] visited = new boolean[dungeons.length];

        dfs(k, 0, visited);

        return max;
    }

    public void dfs(int k, int depth, boolean[] visited) {
        max = Math.max(max, depth);

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            if (k < board[i][0]) continue;

            visited[i] = true;
            dfs(k - board[i][1], depth + 1, visited);
            visited[i] = false;
        }
    }
}
