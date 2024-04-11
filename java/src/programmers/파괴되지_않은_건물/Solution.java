package programmers.파괴되지_않은_건물;

class Solution {
    private static final int ATTACK = 1;
    private static final int REPAIR = 2;

    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        int width = board.length;
        int height = board[0].length;
        int[][] additional = new int[width + 1][height + 1];

        for(int[] skill : skills) {
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = skill[5] * (type == ATTACK ? -1 : 1);            

            additional[r1][c1] += degree;
            additional[r2 + 1][c2 + 1] += degree;                

            additional[r2 + 1][c1] -= degree;
            additional[r1][c2 + 1] -= degree;
        }

        for (int i = 0; i < width; i++) {
            for (int j = 1; j < height; j++) {
                additional[i][j] += additional[i][j-1];
            }
        }

        for (int j = 0; j <= height; j++) {
            for (int i = 1; i < width; i++) {
                additional[i][j] += additional[i-1][j];
            }
        }

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                if(board[i][j] + additional[i][j] > 0) {
                    answer++;
                } 
            }
        }

        return answer;
    }
}