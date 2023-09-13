package programmers.공원산책;

/*
문제 설명
지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다. 산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.

["방향 거리", "방향 거리" … ]
예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다. 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.

주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.

image

공원을 나타내는 문자열 배열 park, 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때, 로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
3 ≤ park의 길이 ≤ 50
3 ≤ park[i]의 길이 ≤ 50
park[i]는 다음 문자들로 이루어져 있으며 시작지점은 하나만 주어집니다.
S : 시작 지점
O : 이동 가능한 통로
X : 장애물
park는 직사각형 모양입니다.
1 ≤ routes의 길이 ≤ 50
routes의 각 원소는 로봇 강아지가 수행할 명령어를 나타냅니다.
로봇 강아지는 routes의 첫 번째 원소부터 순서대로 명령을 수행합니다.
routes의 원소는 "op n"과 같은 구조로 이루어져 있으며, op는 이동할 방향, n은 이동할 칸의 수를 의미합니다.
op는 다음 네 가지중 하나로 이루어져 있습니다.
N : 북쪽으로 주어진 칸만큼 이동합니다.
S : 남쪽으로 주어진 칸만큼 이동합니다.
W : 서쪽으로 주어진 칸만큼 이동합니다.
E : 동쪽으로 주어진 칸만큼 이동합니다.
1 ≤ n ≤ 9
입출력 예
park	routes	result
["SOO","OOO","OOO"]	["E 2","S 2","W 1"]	[2,1]
["SOO","OXX","OOO"]	["E 2","S 2","W 1"]	[0,1]
["OSO","OOO","OXO","OOO"]	["E 2","S 3","W 1"]	[0,0]
입출력 예 설명
입출력 예 #1

입력된 명령대로 동쪽으로 2칸, 남쪽으로 2칸, 서쪽으로 1칸 이동하면 [0,0] -> [0,2] -> [2,2] -> [2,1]이 됩니다.

입출력 예 #2

입력된 명령대로라면 동쪽으로 2칸, 남쪽으로 2칸, 서쪽으로 1칸 이동해야하지만 남쪽으로 2칸 이동할 때 장애물이 있는 칸을 지나기 때문에 해당 명령을 제외한 명령들만 따릅니다. 결과적으로는 [0,0] -> [0,2] -> [0,1]이 됩니다.

입출력 예 #3

처음 입력된 명령은 공원을 나가게 되고 두 번째로 입력된 명령 또한 장애물을 지나가게 되므로 두 입력은 제외한 세 번째 명령만 따르므로 결과는 다음과 같습니다. [0,1] -> [0,0]
 */
class Solution {
    private String[] park;

    private int H;
    private int W;

    /**
     * @throws Exception
     */
    public int[] solution(String[] park, String[] routes) throws Exception {
        this.initPark(park);

        Position cur = this.getStartPosition();

        for (String route : routes) {
            String[] r = route.split(" ");

            Offset offset = new Offset(r[0]);
            int distant = Integer.parseInt(r[1]);

            Position next = cur.getNext(offset, distant);

            if (isOutOfArea(next)) {
                continue;
            }

            if (isBlocked(cur, offset, distant)) {
                continue;
            }

            cur = next;
        }

        return cur.toArray();
    }

    private void initPark(String[] park) {
        this.park = park;
        this.H = park.length - 1;
        this.W = park[0].length() - 1;
    }

    private Position getStartPosition() throws Exception {
        for (int h = 0; h <= this.H; h++) {
            for (int w = 0; w <= this.W; w++) {
                if (getItem(h, w) == 'S') {
                    return new Position(h, w);
                }
            }
        }

        throw new Exception();
    }

    private char getItem(int h, int w) {
        return this.park[h].charAt(w);
    }

    private boolean isOutOfArea(Position position) {
        int h = position.getH();
        int w = position.getW();
        return h < 0 || h > this.H || w < 0 || w > this.W;
    }

    private boolean isBlocked(Position position, Offset offset, int distant) {
        for (; distant > 0; distant--) {
            Position next = position.getNext(offset, 1);

            if (this.getItem(next.getH(), next.getW()) == 'X')
                return true;

            position = next;
        }

        return false;
    }
}

class Position {
    private int h;
    private int w;

    public Position(int h, int w) {
        this.h = h;
        this.w = w;
    }

    public Position getNext(Offset offset, int distant) {
        int h = this.h + (offset.getH() * distant);
        int w = this.w + (offset.getW() * distant);
        return new Position(h, w);
    }

    public int getH() {
        return this.h;
    }

    public int getW() {
        return this.w;
    }

    public int[] toArray() {
        return new int[] { this.h, this.w };
    }
}

class Offset {
    private int h;
    private int w;

    public Offset(String direction) throws Exception {
        switch (direction) {
            case "N":
                this.h = -1;
                this.w = 0;
                break;
            case "S":
                this.h = 1;
                this.w = 0;
                break;
            case "W":
                this.h = 0;
                this.w = -1;
                break;
            case "E":
                this.h = 0;
                this.w = 1;
                break;
            default:
                throw new Exception();
        }
    }

    public int getH() {
        return this.h;
    }

    public int getW() {
        return this.w;
    }
}
