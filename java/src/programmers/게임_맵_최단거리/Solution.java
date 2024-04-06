/**
 * 문제 설명
사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.

단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.

제한사항
word의 길이는 1 이상 5 이하입니다.
word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
입출력 예
word	result
"AAAAE"	6
"AAAE"	10
"I"	1563
"EIO"	1189
입출력 예 설명
입출력 예 #1

사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA", "AAA", "AAAA", "AAAAA", "AAAAE", ... 와 같습니다. "AAAAE"는 사전에서 6번째 단어입니다.

입출력 예 #2

"AAAE"는 "A", "AA", "AAA", "AAAA", "AAAAA", "AAAAE", "AAAAI", "AAAAO", "AAAAU"의 다음인 10번째 단어입니다.

입출력 예 #3

"I"는 1563번째 단어입니다.

입출력 예 #4

"EIO"는 1189번째 단어입니다.
 */

package programmers.게임_맵_최단거리;

import java.util.*;

class Point {
    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Node {
    private final Point position;
    private final int dist;

    Node(Point position, int dist) {
        this.position = position;
        this.dist = dist;
    }

    public int getDist() {
        return dist;
    }

    public Point getPosition() {
        return position;
    }
}

class Solution {
    private final List<Point> OFFSET = Arrays.asList(new Point[]{
            new Point(0, 1),
            new Point(1, 0),
            new Point(0, -1),
            new Point(-1, 0),
    });

    public int solution(int[][] maps) {
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.add(new Node(new Point(0, 0),1));
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Point curPosition = cur.getPosition();
            
            if (isVisited(maps, curPosition)) {
                continue;
            }

            if (isDestination(maps, cur.getPosition())) {
                return cur.getDist();
            }
            
            setVisited(maps, curPosition);

            OFFSET.stream()
                .filter((offset -> isMoveable(maps, curPosition, offset)))
                .map(offset -> getNextNode(cur, offset))
                .forEach(node -> queue.add(node));
        }

        return -1;
    }
    
    private boolean isVisited(int[][] maps, Point position) {
        return maps[position.getY()][position.getX()] == 0;
    }

    private void setVisited(int[][] maps, Point position) {
        maps[position.getY()][position.getX()] = 0;
    }
    
    private Boolean isDestination(int[][] maps, Point position) {
        return position.getX() == maps[0].length - 1
               && position.getY() == maps.length - 1;
    }

    private Boolean isMoveable(int[][] maps, Point cur, Point offset) {
        int nextX = cur.getX() + offset.getX();
        int nextY = cur.getY() + offset.getY();

        return nextX >= 0
               && nextX < maps[0].length
               && nextY >= 0
               && nextY < maps.length
       ;
    }

    private Node getNextNode(Node cur, Point offset) {
        Point curPosition = cur.getPosition();
        Point nextPosition = new Point(curPosition.getX() + offset.getX(), curPosition.getY() + offset.getY());
        return new Node(nextPosition, cur.getDist() + 1);
    }
}